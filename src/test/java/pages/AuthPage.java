package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class AuthPage {

    //locators
    SelenideElement loginInput = $("input[name=phone]"),
            passwordInput = $("input[name=password]"),
            submitButton = $(".button.button-main"),
            errorMessage = $("div.form__notice.form__notice_error:nth-child(4)"),
            restorePassButton = $(".button-restore-password");

    //actions

    @Step("Ввести логин")
    public AuthPage setLogin(String login) {
        loginInput.val(login);
        return this;
    }

    @Step("Ввести пароль")
    public AuthPage setPassword(String pass) {
        passwordInput.val(pass);
        return this;
    }

    @Step("Проверка сообщения о неверной паре логин/пароль")
    public AuthPage checkErrorMessage(String text) {
        errorMessage.shouldHave(Condition.text(text));
        return this;
    }

    @Step("Нажать кнопку 'Войти'")
    public AuthPage submitClick() {
        submitButton.click();
        return this;
    }

    @Step("Нажать кнопку 'Восстановить пароль'")
    public AuthPage clickRestorePassword(){
        restorePassButton.click();
        return this;
    }

}