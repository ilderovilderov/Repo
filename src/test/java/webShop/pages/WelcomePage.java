package webShop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WelcomePage {
    private final SelenideElement registerButton =  $("a.ico-register");
    private final SelenideElement loginLink = $(".ico-login");
    private final ElementsCollection userEmailInHeader = $$("div.header-links ul li a");

    @Step("Переход на страницу регистрации")
    public RegistrationPage openRegistration() {
        registerButton.click();
        return new RegistrationPage();
    }

    @Step("Переход на страницу авторизации")
    public LoginPage openLogin() {
        loginLink.click();
        return new LoginPage();
    }

    @Step("Проверка корректного отображения электронной почты пользователя: {email}")
    public WelcomePage checkUserLoginIn(String email) {
        userEmailInHeader.get(0).shouldHave(text(email));
        return this;
    }
}
