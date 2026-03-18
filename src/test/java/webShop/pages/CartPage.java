package webShop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static webShop.config.Config.*;

public class CartPage {

    private SelenideElement productName = $("a.product-name");
    private String itemQuantityInCart = $("input.qty-input").getAttribute("value");
    private SelenideElement totalPrice = $("span.product-subtotal");

    public CartPage checkProductName() {
        productName.shouldHave(text(itemName));
        return this;
    }

    public CartPage checkQtyItemsInCart() {
        assertEquals(itemQuantity, itemQuantityInCart);
        return this;
    }

    public CartPage totalPriceIfProcessorSlow() {
        totalPrice.shouldHave(text(String.valueOf(
                Float.parseFloat(itemPrice) * Float.parseFloat(itemQuantity))));
        return this;
    }

    public CartPage totalPriceIfProcessorMedium() {
        totalPrice.shouldHave(text(String.valueOf(
                Float.parseFloat(itemPrice) * Float.parseFloat(itemQuantity) + 15 * Float.parseFloat(itemQuantity))));
        return this;
    }

    public CartPage totalPriceIfProcessorFast() {
        totalPrice.shouldHave(text(String.valueOf(
                Float.parseFloat(itemPrice) * Float.parseFloat(itemQuantity) + 100 * Float.parseFloat(itemQuantity))));
        return this;
    }
}
