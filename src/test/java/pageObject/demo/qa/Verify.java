package pageObject.demo.qa;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Verify {
    private SelenideElement sumbitButton = $("#submit");
    private SelenideElement verifyText =  $("#example-modal-sizes-title-lg");

    public Verify checkText () {
        sumbitButton.click();
        verifyText.shouldHave(text("Thanks for submitting the form"));
        return this;
    }
}
