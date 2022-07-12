package tests;

import config.ConfigurationCenter;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AuthPage;
import pages.RecoveryPage;

public class PasswordRecoveryTests extends TestBase {
    AuthPage authPage = new AuthPage();
    RecoveryPage recoveryPage = new RecoveryPage();

    @Test
    @AllureId("11104")
    @DisplayName("Проверка, что телефон введенный на странице авторизации подставляется на странице восстановления пароля")
    void recoveryPasswordActiveUser() {
        authPage.openAuthPage()
                .setLogin(ConfigurationCenter.configTestData.forgetUserLogin())
                .clickRestorePassword();
        recoveryPage.checkPageName()
                .checkInputPhone(ConfigurationCenter.configTestData.forgetUserLogin())
                .clickButtonRecoveryPass()
                .checkSuccessPopUp();
    }

    @Test
    @AllureId("11106")
    @DisplayName("Негативная проверка восстановления пароля незарегистрированным пользователем")
    void recoveryPasswordNonExistentUser() {
        recoveryPage.openRecoveryPage()
                .checkPageName()
                .enterRecoveryPhone(ConfigurationCenter.configTestData.nonExistentUser())
                .clickButtonRecoveryPass()
                .checkErrorPhoneMessage();
    }
}
