package pageObject.otherTests;

import com.codeborne.selenide.SelenideElement;

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

    public SwagLabsShop inputUsername(String user) {
        username.setValue(user);

        return this;
    }

    public SwagLabsShop inputPassword(String pass) {
        password.setValue(pass);
        loginButton.click();

        return this;
    }

    public SwagLabsShop chooseBikeLight() {
        bikeLightButton.click();

        return this;
    }

    public SwagLabsShop makeOrder() {
        cartLink.click();
        checkoutButton.click();

        return this;
    }

    public SwagLabsShop setPersonalData(String fname, String lname, String code) {
        firstName.setValue(fname);
        lastName.setValue(lname);
        postalCode.setValue(code);
        continueButton.click();

        return this;
    }

    public SwagLabsShop submit() {
        submitButton.click();

        return this;
    }

    public SwagLabsShop verify() {
        verifyArea.shouldHave(text("Thank you for your order!"));

        return this;
    }
}
