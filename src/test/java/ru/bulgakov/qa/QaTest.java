package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class QaTest {

    @Test
    void mentoringPriceShouldBe47000Test() {
        Configuration.browserSize = "1920x1080";

        open("https://ivanbulgakovqa.ru");
        $$(".t-menu__list li").get(4).click();
        $(byText("Хочу вкатиться в QA")).click();
        $(byText("Бегу оплачивать")).click();
        sleep(5000);
        switchTo().window(1);
        $(".styles-module-scss-module__t92_WG__price h2").shouldHave(text(" 47 000.00 "));
    }

    @Test
    void loginAndSendMessageGmail() {
        Configuration.browserSize = "1920x1080";

        open("https://mail.google.com/");
        $("[type=email]").setValue("alexandertest73@gmail.com");
        $("#identifierNext").click();
        sleep(5000);
        $("[type=password]").setValue("1609Test");
        $("#passwordNext").click();
    }

    @Test
    void practiceFormDemoQA() {
        Configuration.browserSize = "1920x1080";

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Alexander");
        $("#lastName").setValue("Test");
        $("#userEmail").setValue("alexander@test.ru");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("9930900333");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__day--020:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("A");
        $$("[role=listbox] div").get(2).click();

        $("#subjectsInput").setValue("Com");
        $$("[role=listbox] div").get(0).click();

        $("#hobbies-checkbox-2").parent().click();
        $("#hobbies-checkbox-3").parent().click();

        $("#uploadPicture").uploadFromClasspath("obezgan.jpg");
        $("#currentAddress").setValue("WWW LENINGRAD SBP TOCHKA RU");

        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();

        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    @Test
    void studyPriceShouldBe47000Test() {
        Configuration.browser = "chrome";
        Configuration.pageLoadTimeout = 100000;
        Configuration.timeout = 100000;
        Configuration.holdBrowserOpen = true;

        open("https://ya.ru/");

        $("textarea.search3__input").setValue("bulgakov qa"); // Яндекс поиск
        $("button.search3__button").click();
        $(".DistributionButtonClose").click(); // Поисковая выдача
        $(byText("ivanbulgakova.ru")).click();

        open("https://ivanbulgakovqa.ru/");
        $$(".t-menu__list li").last().click(); // Страница обучения
        $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a/div/span").shouldHave(text("Хочу вкатиться в QA")).click();
        $(byText("Бегу оплачивать")).click();
        switchTo().window(1);
        sleep(5000);

        $("span.ant-select-selection-wrap").click();
        $(byText("RUB")).click();
        $(".styles-module-scss-module__t92_WG__price").$("span h2").shouldHave(text("₽ 47 000 ")); // Страница оплаты
    }
}
