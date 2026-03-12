package pageObject.demo.qa;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PersonalData {
    private SelenideElement firstName = $("#firstName");
    private SelenideElement lastName = $("#lastName");
    private SelenideElement email = $("#userEmail");
    private SelenideElement gender = $("#gender-radio-1");
    private SelenideElement number = $("#userNumber");

    public PersonalData open() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public PersonalData personalinfo() {
        firstName.setValue("Alexander");
        lastName.setValue("Test");
        email.setValue("alexander@test.ru");
        gender.click();
        number.setValue("9930900333");
        return this;
    }
}
