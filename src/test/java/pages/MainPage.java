package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    //locators
    SelenideElement loginButton = $("a.menu-item_login", 1);

    //actions
    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open();
        return this;
    }

    @Step("Нажать кнопку 'Личный кабинет'")
    public MainPage clickPrivateOfficeButton(){
        loginButton.click();
        return this;
    }
}
