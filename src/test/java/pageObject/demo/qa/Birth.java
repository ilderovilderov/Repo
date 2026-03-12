package pageObject.demo.qa;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Birth {
    private SelenideElement date = $("#dateOfBirthInput");
    private SelenideElement year = $(".react-datepicker__year-select");
    private SelenideElement month = $(".react-datepicker__month-select");
    private SelenideElement day = $(".react-datepicker__day--020:not(.react-datepicker__day--outside-month)");

    public Birth dateOfBirth() {
      date.click();
      year.selectOption("1996");
      month.selectOption("December");
      day.click();
      return this;
    }
}

