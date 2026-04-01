package pageObject.otherTests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DemoQARegistration {
    private SelenideElement firstName = $("#firstName");
    private SelenideElement lastName = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement number = $("#userNumber");
    private SelenideElement dateButton = $("#dateOfBirthInput");
    private SelenideElement yearButton = $(".react-datepicker__year-select");
    private SelenideElement monthButton = $(".react-datepicker__month-select");
    private ElementsCollection dayButton = $$(".react-datepicker__day");
    private SelenideElement picture = $("#uploadPicture");
    private SelenideElement currentAddress = $("#currentAddress");
    private SelenideElement chooseState = $("#state");
    private SelenideElement chooseCity =  $("#city");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement verifyArea = $("#example-modal-sizes-title-lg");
    private SelenideElement youSubjects = $("#react-select-2-option-0");

    @Step("Заполнение строки с именем: {name}")
    public DemoQARegistration setFirstName(String name) {
        firstName.setValue(name);
        return this;
    }

    @Step("Заполнение строки с фамилией: {last}")
    public DemoQARegistration setLastName(String last) {
        lastName.setValue(last);
        return this;
    }

    @Step("Заполнение строки с email: {email}")
    public DemoQARegistration setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Заполнение строки с номером телефона: {phoneNumber}")
    public DemoQARegistration setPhoneNumber(String phoneNumber) {
        number.setValue(phoneNumber);
        return this;
    }

    @Step("Выбор пола")
    public DemoQARegistration chooseGender(int gender) {
        $("#gender-radio-%s".formatted(gender)).click();
        return this;
    }

    @Step("Указать дату рождения: {year}, {month}, {day}")
    public DemoQARegistration setBirthDate(String year, String month, int day) {
        dateButton.click();
        yearButton.selectOption(year);
        monthButton.selectOption(month);
        dayButton.get(day - 1).click(); // оставил всё как есть
        return this;
    }

    @Step("Выбор учебных дисциплин: {subject}")
    public DemoQARegistration chooseSubjects(String... subject) {
        for (String index : subject) {
            $("#subjectsInput").click();                    // Реализовать через index смог только таким способом,
            $("#subjectsInput").setValue(index);            // в несколько действий. Элемент на сайте, с этим выпадающим списком,
            youSubjects.click();                                      // реализован не просто как-то.
        }
        return this;
    }

    @Step("Выбор хобби: {hobbie}")
    public DemoQARegistration chooseHobbies(int... hobbie) {
        for (int index : hobbie) {
            $("#hobbies-checkbox-%s".formatted(index)).click();
        }
        return this;
    }

    @Step("Загрузка фото")
    public DemoQARegistration uploadPicture() {
        picture.uploadFromClasspath("obezgan.jpg");
        return this;
    }

    @Step("Указание адреса: {Address}")
    public DemoQARegistration setCurrentAddress(String Address) {
        currentAddress.setValue(Address);
        return this;
    }

    @Step("Выбор штата и города проживания: {yourState}, {yourCity}")
    public DemoQARegistration chooseStateAndCity(String yourState, String yourCity) {
        chooseState.click();
        $(byText(yourState)).click();
        chooseCity.click();
        $(byText(yourCity)).click();
        return this;
    }

    @Step("Подтверждение регистрации")
    public DemoQARegistration submit() {
        submitButton.click();
        return this;
    }

    @Step("Проверка надписи об успешном заполении формы")
    public DemoQARegistration verify() {
        verifyArea.shouldHave(text("Thanks for submitting the form"));
        return this;
    }
}
