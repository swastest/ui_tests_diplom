package tests;

import com.github.javafaker.Faker;
import config.ConfigurationCenter;
import io.qameta.allure.AllureId;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AuthPage;
import pages.MainPage;
import pages.PrivateOfficePage;

@Tag("auth")
public class AuthTests extends TestBase {
    Faker faker = new Faker();
    AuthPage authPage = new AuthPage();
    MainPage mainPage = new MainPage();
    PrivateOfficePage privateOfficePage = new PrivateOfficePage();

    String errorMessage = "Введен неверный номер телефона или пароль",
            negativeLogin = "7903" + faker.numerify("#######"),
            negativePassword = "7903" + faker.numerify("#######"),
            accountStatusMessage = "Ваш аккаунт заблокирован администратором сервиса";

    @Test
    @AllureId("11102")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Авторизация пользователя со статусом Активен")
    void authActiveUser() {
        mainPage.openPage()
                .clickPrivateOfficeButton();
        authPage.setLogin(ConfigurationCenter.configTestData.userActiveLogin())
                .setPassword(ConfigurationCenter.configTestData.userActivePassword())
                .submitClick();
        privateOfficePage
                .clickProfileButton()
                .checkProfileTable(ConfigurationCenter.configTestData.userActiveFirstName(), ConfigurationCenter.configTestData.userActiveLastName(),
                        ConfigurationCenter.configTestData.expectPhoneActiveUser());
    }

    @Test
    @AllureId("11108")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Негативный тест авторизации")
    void negativeAuthTest() {
        mainPage.openPage()
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
        mainPage.openPage()
                .clickPrivateOfficeButton();
        authPage.setLogin(ConfigurationCenter.configTestData.userBlockLogin())
                .setPassword(ConfigurationCenter.configTestData.userBlockPassword())
                .submitClick();
        privateOfficePage.checkAccountStatus(accountStatusMessage)
                .checkProfileTable(ConfigurationCenter.configTestData.userBlockFirstName(), ConfigurationCenter.configTestData.userBlockLastName(),
                        ConfigurationCenter.configTestData.userBlockLogin());
    }
}
