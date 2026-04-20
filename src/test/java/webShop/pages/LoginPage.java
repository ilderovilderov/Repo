package webShop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement loginButton = $("a.ico-login");
    private final SelenideElement pageTitle = $("div.page-title h1");
    private final SelenideElement emailInput = $("input#Email");
    private final SelenideElement passwordInput = $("input#Password");
    private final SelenideElement rememberBox = $("input#RememberMe");
    private final SelenideElement loginInButton = $("input.login-button");

    @Step("Переход на страницу авторизации")
    public LoginPage openLogin() {
        loginButton.click();
        return this;
    }

    @Step("Проверка нахождения на странице авторизации")
    public LoginPage checkLoginPageOpened() {
        pageTitle.shouldHave(text("Welcome, Please Sign In!"));
        return this;
    }

    @Step("Ввести электронную почту: {email}")
    public LoginPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Проверить наличие надписи о некорректном email")
    public LoginPage verifyEmailValidationAppear() {
        $("span.field-validation-error").shouldBe(visible);
        return this;
    }
    @Step("Ввести пароль: {password}")
    public LoginPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Нажать на кнопку: Запомнить меня")
    public LoginPage rememberMeCheckBox() {
        rememberBox.click();
        return this;
    }

    @Step("Нажать кнопку Login In")
    public WelcomePage loginIn() {
        loginInButton.click();
        return new WelcomePage();
    }
}
