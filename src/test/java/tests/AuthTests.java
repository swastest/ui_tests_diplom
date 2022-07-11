package tests;

import com.github.javafaker.Faker;
import configs.TestDataInterface;
import io.qameta.allure.AllureId;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AuthPage;
import pages.MainPage;
import pages.PrivateOfficePage;

public class AuthTests extends TestBase {

    TestDataInterface config = ConfigFactory.create(TestDataInterface.class);
    Faker faker = new Faker();
    String errorMessage = "Введен неверный номер телефона или пароль",
            negativeLogin = "7903" + faker.numerify("#######"),
            negativePassword = "7903" + faker.numerify("#######"),
            accountStatusMessage = "Ваш аккаунт заблокирован администратором сервиса";

    AuthPage authPage = new AuthPage();
    MainPage mainPage = new MainPage();
    PrivateOfficePage privateOfficePage = new PrivateOfficePage();

    @Test
    @AllureId("11102")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Авторизация пользователя со статусом Активен")
    void authActiveUser() {
        mainPage.openPage("")
                .clickPrivateOfficeButton();
        authPage.setLogin(config.userActiveLogin())
                .setPassword(config.userActivePassword())
                .submitClick();
        privateOfficePage
                .clickProfileButton()
                .checkProfileTable(config.userActiveFirstName(), config.userActiveLastName(),
                        config.expectPhoneActiveUser());
    }

    @Test
    @AllureId("11108")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Негативный тест авторизации")
    void negativeAuthTest() {
        mainPage.openPage("")
                .clickPrivateOfficeButton();
        authPage.setLogin(negativeLogin)
                .setPassword(negativePassword)
                .submitClick()
                .checkErrorMessage(errorMessage);
    }

    @Test
    @AllureId("11103")
    @DisplayName("Авторизация заблокированного пользователя")
    void authBlockUser() {
        mainPage.openPage("")
                .clickPrivateOfficeButton();
        authPage.setLogin(config.userBlockLogin())
                .setPassword(config.userBlockPassword())
                .submitClick();
        privateOfficePage.checkAccountStatus(accountStatusMessage)
                .checkProfileTable(config.userBlockFirstName(), config.userBlockLastName(),
                        config.userBlockLogin());
    }

}
