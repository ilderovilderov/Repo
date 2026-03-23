package webShop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private final SelenideElement productName = $("a.product-name");
    private final SelenideElement totalPrice = $("span.product-subtotal");
    private final SelenideElement quantityInput = $("input.qty-input");

    public String getItemName() {
        return productName.getText();
    }

    public String getSubtotal() {
        return totalPrice.getText();
    }

    public String getQuantity() {
        return quantityInput.getAttribute("value");
    }
}
