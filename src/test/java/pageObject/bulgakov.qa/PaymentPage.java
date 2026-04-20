package pageObject.bulgakov.qa;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PaymentPage {
    private SelenideElement price = $(".styles-module-scss-module__t92_WG__price h2");

    @Step("Проверка отображения цены: 47 000 рублей")
    public void verfyPrice () {
        price.shouldHave(text(" 47 000.00 "));
    }
}
