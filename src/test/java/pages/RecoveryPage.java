package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RecoveryPage {
    //locators
    SelenideElement phoneInput = $("[name=phone]"),
            pageName = $("div.form__title"),
            errorMessage = $("div.form__notice"),
            submitButton = $("button.button-main"),
            popUpSuccessMessage = $(".popup_restore-password");

    //actions
    @Step("Открыть главную страницу")
    public RecoveryPage openRecoveryPage() {
        open("/front/client-restore-password");
        return this;
    }

    @Step("Проверка, что поле заполнено и контент соответствует номеру введенного на странице авторизации")
    public RecoveryPage checkInputPhone(String phone) {
        phoneInput.shouldHave(Condition.value(phone));
        return this;
    }

    @Step("Название страницы соответствует тексту 'Восстановление пароля'")
    public RecoveryPage checkPageName() {
        pageName.shouldHave(Condition.text("Восстановление пароля"));
        return this;
    }

    @Step("Проверка сообщения о незарегистрированном номере")
    public RecoveryPage checkErrorPhoneMessage() {
        errorMessage.shouldHave(Condition.text("Такой пользователь не зарегистрирован"));
        return this;
    }

    @Step("Нажать кнопку 'Восстановить пароль'")
    public RecoveryPage clickButtonRecoveryPass() {
        submitButton.click();
        return this;
    }

    @Step("Проверка поп-ап сообщения об успешной отправке кода восстановления пароля")
    public RecoveryPage checkSuccessPopUp() {
        popUpSuccessMessage.shouldHave(Condition.text("Новый пароль выслан по SMS"));
        return this;
    }

    @Step("Ввести номер телефона незарегистрированного пользователя")
    public RecoveryPage enterRecoveryPhone(String phone) {
        phoneInput.val(phone);
        return this;
    }
}
