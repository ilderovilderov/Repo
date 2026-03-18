package webShop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webShop.pages.MainPage;
import webShop.steps.AuthSteps;

import static com.codeborne.selenide.Selenide.*;
import static webShop.config.Config.*;

public class CartTest {

    private static final Faker faker = new Faker();
    private final AuthSteps authSteps = new AuthSteps();

    @BeforeEach
    void beforeEach() {
        authSteps.registerNewUser();
    }

    @Test
    void addItemToCartTest() {

        open(WEB_SHOP_URL, MainPage.class)
                .clickComputerButton()
                .chooseDesktop()
                .selectProcessor(2)
                .setQuantity("5")
                .checkNameAndPrice()
                .addToCart()
                .checkQtyItmemsInCart()
                .checkSuccessNotification()
                .goToCart()
                .checkProductName()
                .checkQtyItemsInCart()
           //     .totalPriceIfProcessorSlow();               // В общем, общую цену товара на выходе реализовал так:
           //     .totalPriceIfProcessorMedium();             // в зависимости от того, какой процессор выбираем
                .totalPriceIfProcessorFast();                 // такой метод и запускаем. Всё работает. По другому я не смог.
        }                                                     // И с нейросетями пробовал и без, не дошло, в общем :)
}
