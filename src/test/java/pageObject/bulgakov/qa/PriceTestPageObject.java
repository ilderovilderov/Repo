package pageObject.bulgakov.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.page;

public class PriceTestPageObject {
    @Test
    void PriceShouldBe47000Test() {
        IvanMainPage ivanMainPage = page(IvanMainPage.class);
        ivanMainPage.open()
                .goToMentoring()
                .goToPay()
                .verfyPrice();

    }
}
