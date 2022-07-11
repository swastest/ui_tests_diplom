package tests;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import helpers.DriverUtils;
import helpers.GetFromDataBase;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class LandingPageTests extends TestBase {

    @Test
    @AllureId("11105")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка стоимости на главной странице")
    void priceCityTests() {
        GetFromDataBase bd = new GetFromDataBase();
        String city = System.getProperty("city", "МОСКВА"),
                price = bd.findPrice(city).split("\\.")[0];

        step("Открыть главную страницу", () -> {
            Selenide.open("");
        });

        step("Выбрать город", () -> {
            $("div.city-select.selected-city", 1).click();
            $("#find-city").setValue(city);
            $("li.ui-menu-item").click();

        });

        step("Проверить стоимость уборки для выбранного города", () -> {
            $("div.city-select.selected-city", 1).shouldHave(text(city));
            $("div.form-cost__value > span.form-cost__sum").shouldHave(text(price));
        });
    }

    @Test
    @AllureId("11111")
    @DisplayName("Проверка страницы 'Сотрудничество'")
    void forPerformersTest() {
        step("Открыть главную страницу", () -> {
            Selenide.open("https://liveinclean.ru/");
        });

        step("Нажать кнопку 'Исполнителям'", () -> {
            $(By.linkText("Исполнителям")).click();
        });

        step("Проверка контента страницы 'Сотрудничество'", () -> {
            $("div.header-desc.heading-performers").shouldHave(text("Сотрудничество с нами!"));
            $("h2.employment__heading.heading-performers").shouldHave(text("Регистрация в сервисе"));
        });
    }


    @Test
    @AllureId("11109")
    @DisplayName("Негативный тест авторизации")
    void negativeAuthTest() {
        Faker faker = new Faker();
        String login = "7903" + faker.numerify("#######");
        String password = "7903" + faker.numerify("#######");
        step("Открыть главную страницу", () -> {
            Selenide.open("");
        });

        step("Перейти на страницу авторизации", () -> {
            $("a.menu-item_login", 1).click();
        });

        step("Ввести несуществующую пару логин/пароль", () -> {
            $("input[name=phone]").setValue(login);
            $("input[name=password]").setValue(password);
        });

        step("Нажать кнопку 'Войти'", () -> {
            $(".button.button-main").$("span").click();
        });

        step("Проверка подсказки о неверной паре логин/пароль", () -> {
            $("div.form__notice.form__notice_error:nth-child(4)").shouldHave(
                    text("Введен неверный номер телефона или пароль"));
        });
    }

    @Test
    @AllureId("11107")
    @DisplayName("Проверка соответствия в Title")
    void titleTest() {
        step("Открыть главную страницу", () ->
                open(""));

        step("Title соответствует требованию текста 'Live In Clean'", () -> {
            String expectedTitle = "Live In Clean";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @AllureId("11110")
    @DisplayName("Проверка ошибок в консоли")
    void consoleShouldNotHaveErrorsTest() {
        step("Открыть главную страницу", () ->
                open(""));

        step("Проверка консоли на наличие ошибки 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
