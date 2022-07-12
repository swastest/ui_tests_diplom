package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PrivateOfficePage {
    //locators
    SelenideElement userIconButton = $(".user__icon"),
            profileTable = $(".profile-page-item"),
            statusMessage = $("div.msg_warning");

    //actions
    @Step("Нажать кнопку 'Профиль'")
    public PrivateOfficePage clickProfileButton() {
        userIconButton.click();
        return this;
    }

    @Step("Проверка данных в таблице профиля")
    public PrivateOfficePage checkProfileTable(String fistname, String lastname, String login) {
        profileTable.shouldHave(text(fistname), text(lastname), text(login));
        return this;
    }

    @Step("Проверка статуса аккаунта, при авторизации заблокированного пользователя")
    public PrivateOfficePage checkAccountStatus(String text){
        statusMessage.shouldHave(text(text));
        return this;
    }
}
