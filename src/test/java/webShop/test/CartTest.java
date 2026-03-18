package webShop.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webShop.pages.CartPage;
import webShop.pages.MainPage;
import webShop.pages.ProductPage;
import webShop.steps.AuthSteps;

import static com.codeborne.selenide.Selenide.open;
import static java.util.Locale.US;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static webShop.config.Config.WEB_SHOP_URL;

public class CartTest {

    private final AuthSteps authSteps = new AuthSteps();

    @BeforeEach
    void beforeEach() {
        authSteps.registerNewUser();
    }

    @Test
    void addItemToCartTest() {
        int processorIndex = 0; // 0 = slow, 1 = medium, 2 = fast

        ProductPage productPage = open(WEB_SHOP_URL, MainPage.class)
                .hoverComputersMenu()
                .selectDesktops()
                .chooseDesktop();

        String itemName = productPage.getProductName();
        String itemPrice = productPage.getProductPrice();
        String itemQuantity = "5";

        CartPage cartPage = productPage
                .selectProcessor(processorIndex)
                .setQuantity(itemQuantity)
                .addToCart()
                .checkQtyItemsInCart(itemQuantity)
                .checkSuccessNotification()
                .goToCart();

        float processorPrice = getProcessorPrice(processorIndex);
        String expectedTotal = String.format(US, "%.2f",
                (Float.parseFloat(itemPrice) + processorPrice) * Float.parseFloat(itemQuantity));

        assertAll(
                () -> assertEquals(itemName, cartPage.getItemName()),
                () -> assertEquals(expectedTotal, cartPage.getSubtotal()),
                () -> assertEquals(itemQuantity, cartPage.getQuantity())
        );
    }

    private float getProcessorPrice(int processorIndex) {
        return switch (processorIndex) {
            case 0 -> 0f;
            case 1 -> 15f;
            case 2 -> 100f;
            default -> throw new IllegalArgumentException("Unknown processor index: " + processorIndex);
        };
    }
}
