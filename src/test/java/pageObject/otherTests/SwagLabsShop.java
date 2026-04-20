package pageObject.otherTests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SwagLabsShop {
    private SelenideElement username = $("#user-name");
    private SelenideElement password = $("#password");
    private SelenideElement loginButton = $("#login-button");
    private SelenideElement bikeLightButton = $("#add-to-cart-sauce-labs-bike-light");
    private SelenideElement cartLink = $(".shopping_cart_link");
    private SelenideElement checkoutButton = $("#checkout");
    private SelenideElement firstName = $("#first-name");
    private SelenideElement lastName = $("#last-name");
    private SelenideElement postalCode = $("#postal-code");
    private SelenideElement continueButton = $("#continue");
    private SelenideElement submitButton = $("#finish");
    private SelenideElement verifyArea = $(".complete-header");

    @Step("Заполнение строки с юзернеймом: {user}")
    public SwagLabsShop inputUsername(String user) {
        username.setValue(user);
        return this;
    }

    @Step("Заполнение строки с паролем: {pass}")
    public SwagLabsShop inputPassword(String pass) {
        password.setValue(pass);
        return this;
    }

    @Step("Подтверждение авторизации")
    public SwagLabsShop loginIN() {
        loginButton.click();
        return this;
    }

    @Step("Выбор товара: Фонарь для велосипеда")
    public SwagLabsShop chooseBikeLight() {
        bikeLightButton.click();
        return this;
    }

    @Step("Переход на страницу заказа товара")
    public SwagLabsShop makeOrder() {
        cartLink.click();
        checkoutButton.click();
        return this;
    }

    @Step("Ввод данных для совершения заказа: {fname}, {lname}, {code}")
    public SwagLabsShop setPersonalData(String fname, String lname, String code) {
        firstName.setValue(fname);
        lastName.setValue(lname);
        postalCode.setValue(code);
        return this;
    }

    @Step("Подтверждение ввода данных")
    public SwagLabsShop continueOrder() {
        continueButton.click();
        return this;
    }

    @Step("Подтверждение заказа")
    public SwagLabsShop submit() {
        submitButton.click();
        return this;
    }

    @Step("Проверка надписи об успешном выполнении заказа")
    public SwagLabsShop verify() {
        verifyArea.shouldHave(text("Thank you for your order!"));
        return this;
    }
}
