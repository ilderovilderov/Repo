package webShop.pages;

import com.codeborne.selenide.SelenideElement;
import webShop.config.Config;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static webShop.config.Config.*;

public class ProductPage {

    private final SelenideElement quantityInput = $("input.qty-input");
    private final SelenideElement addToCartButton = $("input.add-to-cart-button");
    private final SelenideElement successNotification = $("div.bar-notification.success");
    private final SelenideElement qtyItmemsInCart = $("span.cart-qty");
    private final SelenideElement cartIcon = $("a.ico-cart");
    private final SelenideElement itemNameElement = $("[itemprop=name]");
    private final SelenideElement itemPriceElement = $("[itemprop=price]");


    public ProductPage selectProcessor(int index) {
        $$("dl dd ul").get(0).$$("li input").get(index).click();
        return this;
    }

    public ProductPage setQuantity(String quantity) {
        quantityInput.setValue(quantity);
        Config.itemQuantity = quantity;
        return this;
    }

    public ProductPage checkNameAndPrice() {
        itemName = itemNameElement.getText();
        itemPrice = itemPriceElement.getText();
        return this;
    }

    public ProductPage addToCart()  {
        addToCartButton.click();;
        return this;
    }

    public ProductPage checkQtyItmemsInCart()  {
        qtyItmemsInCart.shouldHave(text("(" + itemQuantity + ")"));
        return this;
    }

    public ProductPage checkSuccessNotification()  {
        successNotification.shouldBe(visible);
        return this;
    }

    public CartPage goToCart() {
        cartIcon.click();
        return new CartPage();
    }
}
