package pageObject.bulgakov.qa;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class IvanMainPage {
    private ElementsCollection button = $$(".t-menu__list li");
    private SelenideElement vkat = $(byText("Хочу вкатиться в QA"));
    private SelenideElement payLavandos = $(byText("Бегу оплачивать"));

    public IvanMainPage open(){
        Selenide.open("https://ivanbulgakovqa.ru");
        return this;
    }

    public IvanMainPage goToMentoring() {
        button.get(4).click();
        vkat.click();
        return this;
    }

    public PaymentPage goToPay() {
        payLavandos.click();
        sleep(5000);
        switchTo().window(1);
        return page(PaymentPage.class);
    }
}
