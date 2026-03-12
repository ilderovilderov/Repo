package pageObject.demo.qa;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCity {
    private SelenideElement state = $("#state");
    private SelenideElement city =  $("#city");

    public StateAndCity chooseStateAndCity () {
        state.click();
        $(byText("NCR")).click();
        city.click();
        $(byText("Delhi")).click();
        return this;
    }
}
