package pageObject.demo.qa;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Hobbies {
    private SelenideElement checkbox2 = $("#hobbies-checkbox-2").parent();
    private SelenideElement checkbox3 = $("#hobbies-checkbox-3").parent();

    public Hobbies chooseHobbies () {
        checkbox2.click();
        checkbox3.click();
        return this;
    }
}
