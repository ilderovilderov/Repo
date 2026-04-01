package pageObject.bulgakov.qa;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class IvanMainPage {
    private ElementsCollection button = $$(".t-menu__list li");
    private SelenideElement vkat = $(byText("Хочу вкатиться в QA"));
    private SelenideElement payLavandos = $(byText("Бегу оплачивать"));

    @Step("Перейти на главную страницу: ivanbulgakovqa.ru")
    public IvanMainPage open(){
        Selenide.open("https://ivanbulgakovqa.ru");
        return this;
    }

    @Step("Нажать на кнопку: Сразу к менторству")
    public IvanMainPage goToMentoring() {
        button.get(4).click();
        vkat.click();
        return this;
    }

    @Step("Перейти на страницу оплаты")
    public PaymentPage goToPay() {
        payLavandos.click();
        sleep(5000);
        switchTo().window(1);
        return page(PaymentPage.class);
    }
}
