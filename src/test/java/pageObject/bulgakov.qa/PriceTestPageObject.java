package pageObject.bulgakov.qa;

import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import jUnit.TestBase;

import static com.codeborne.selenide.Selenide.page;

public class PriceTestPageObject extends TestBase {
    @Test
    @Tag("positive")
    @DisplayName("Проверка стоимости менторства: 47 000 рублей")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("@ilderovilderov")
    @Link(name = "TASK-001")
    void PriceShouldBe47000Test() {
        IvanMainPage ivanMainPage = page(IvanMainPage.class);
        ivanMainPage.open()
                .goToMentoring()
                .goToPay()
                .verfyPrice();

    }
}
