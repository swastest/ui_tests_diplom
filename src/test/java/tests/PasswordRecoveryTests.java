package tests;

import configs.TestDataInterface;
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
    @DisplayName("Восстановление пароля по коду из смс зарегистрированного пользователя")
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
