package webShop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private final SelenideElement productName = $("a.product-name");
    private final SelenideElement totalPrice = $("span.product-subtotal");
    private final SelenideElement quantityInput = $("input.qty-input");

    @Step("Проверка названия товара в корзине")
    public String getItemName() {
        return productName.getText();
    }

    @Step("Проверка стоимости товара в корзине")
    public String getSubtotal() {
        return totalPrice.getText();
    }

    @Step("Проверка количества товаров в корзине")
    public String getQuantity() {
        return quantityInput.getAttribute("value");
    }
}
