package pageObject.bulgakov.qa;

import org.junit.jupiter.api.Test;
import jUnit.TestBase;

import static com.codeborne.selenide.Selenide.page;

public class PriceTestPageObject extends TestBase {
    @Test
    void PriceShouldBe47000Test() {
        IvanMainPage ivanMainPage = page(IvanMainPage.class);
        ivanMainPage.open()
                .goToMentoring()
                .goToPay()
                .verfyPrice();

    }
}
