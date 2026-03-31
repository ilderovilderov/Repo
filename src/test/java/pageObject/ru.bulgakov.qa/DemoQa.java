package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import jUnit.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQa extends TestBase {

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
}
