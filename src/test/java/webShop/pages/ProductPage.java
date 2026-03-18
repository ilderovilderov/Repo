package webShop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPage {

    private final SelenideElement quantityInput = $("input.qty-input");
    private final SelenideElement addToCartButton = $("input.add-to-cart-button");
    private final SelenideElement successNotification = $("div.bar-notification.success");
    private final SelenideElement qtyItemsInCart = $("span.cart-qty");
    private final SelenideElement cartIcon = $("a.ico-cart");
    private final SelenideElement itemNameElement = $("[itemprop=name]");
    private final SelenideElement itemPriceElement = $("[itemprop=price]");

    public String getProductName() {
        return itemNameElement.getText();
    }

    public String getProductPrice() {
        return itemPriceElement.getText();
    }

    public ProductPage selectProcessor(int index) {
        $$("dl dd ul").get(0).$$("li input").get(index).click();
        return this;
    }

    public ProductPage setQuantity(String quantity) {
        quantityInput.setValue(quantity);
        return this;
    }

    public ProductPage addToCart() {
        addToCartButton.click();
        return this;
    }

    public ProductPage checkQtyItemsInCart(String expectedQty) {
        qtyItemsInCart.shouldHave(text("(" + expectedQty + ")"));
        return this;
    }

    public ProductPage checkSuccessNotification() {
        successNotification.shouldBe(visible);
        return this;
    }

    public CartPage goToCart() {
        cartIcon.click();
        return new CartPage();
    }
}
