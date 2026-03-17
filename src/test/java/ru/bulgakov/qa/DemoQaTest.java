package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaTest {

    @Test
    void textBoxTest() {
        Configuration.browserSize = "1920x1080";

        open("https://demoqa.com/text-box");

        $("#userName").setValue("Alexander Test");
        $("#userEmail").setValue("alexander@test.ru");
        $("#currentAddress").setValue("WWW LENINGRAD SBP TOCHKA RU");
        $("#permanentAddress").setValue("WWW LENINGRAD SBP TOCHKA RU");

        $("#submit").click();

        $("#output #name").shouldHave(text("Alexander Test"));
        $("#output #email").shouldHave(text("alexander@test.ru"));
    }
}
