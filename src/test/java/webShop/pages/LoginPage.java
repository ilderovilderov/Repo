package webShop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement loginButton = $("a.ico-login");
    private final SelenideElement pageTitle = $("div.page-title h1");
    private final SelenideElement emailInput = $("input#Email");
    private final SelenideElement passwordInput = $("input#Password");
    private final SelenideElement rememberBox = $("input#RememberMe");
    private final SelenideElement loginInButton = $("input.login-button");

    public LoginPage openLogin() {
        loginButton.click();
        return this;
    }

    public LoginPage checkLoginPageOpened() {
        pageTitle.shouldHave(text("Welcome, Please Sign In!"));
        return this;
    }

    public LoginPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public LoginPage rememberMeCheckBox() {
        rememberBox.click();
        return this;
    }

    public WelcomePage loginIn() {
        loginInButton.click();
        return new WelcomePage();
    }
}
