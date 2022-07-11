package tests;

import configs.TestDataInterface;
import io.qameta.allure.AllureId;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AuthPage;
import pages.MainPage;
import pages.RecoveryPage;

public class PasswordRecoveryTests extends TestBase {

    TestDataInterface config = ConfigFactory.create(TestDataInterface.class);

    MainPage mainPage = new MainPage();
    AuthPage authPage = new AuthPage();
    RecoveryPage recoveryPage = new RecoveryPage();

    @Test
    @AllureId("11104")
    @DisplayName("Всплывающее уведомление об отправке смс, с кодом подтверждая, отображается при запросе восстановления пароля")
    void recoveryPasswordActiveUser() {
        mainPage.openPage("")
                .clickPrivateOfficeButton();
        authPage.setLogin(config.forgetUserLogin())
                .clickRestorePassword();
        recoveryPage.checkPageName()
                .checkInputPhone(config.forgetUserLogin())
                .clickButtonRecoveryPass()
                .checkSuccessPopUp();

    }

    @Test
    @AllureId("11106")
    @DisplayName("Негативная проверка восстановления пароля незарегистрированным пользователем")
    void recoveryPasswordNonExistentUser() {
        mainPage.openPage("")
                .clickPrivateOfficeButton();
        authPage.setLogin(config.nonExistentUser())
                .clickRestorePassword();
        recoveryPage.checkPageName()
                .checkInputPhone(config.nonExistentUser())
                .clickButtonRecoveryPass()
                .checkErrorPhoneMessage();

    }

}
