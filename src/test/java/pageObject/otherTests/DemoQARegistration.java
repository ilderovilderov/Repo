package pageObject.demo.qa;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

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
    private SelenideElement youSubject = $("#subjectsInput");
    private ElementsCollection subjectCollection = $$("[role=listbox] div");
    private SelenideElement picture = $("#uploadPicture");
    private SelenideElement currentAddress = $("#currentAddress");
    private SelenideElement chooseState = $("#state");
    private SelenideElement chooseCity =  $("#city");

    public DemoQARegistration setFirstName(String name) {
        firstName.setValue(name);

        return this;
    }

    public DemoQARegistration setLastName(String last) {
        lastName.setValue(last);

        return this;
    }

    public DemoQARegistration setEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public DemoQARegistration setPhoneNumber(String phoneNumber) {
        number.setValue(phoneNumber);

        return this;
    }

    public DemoQARegistration chooseGender(int gender) {
        $("#gender-radio-%s".formatted(gender)).click();

        return this;
    }

    public DemoQARegistration setBirthDate(String year, String month, int day) {
        dateButton.click();
        yearButton.selectOption(year);
        monthButton.selectOption(month);
        dayButton.get(day - 1).click(); // оставил всё как есть

        return this;
    }

    public DemoQARegistration chooseSubjects(String subject) {                         // Вот тут не дошло как выбрать один или несколько
        youSubject.setValue(subject);                                        // возможно также как и в chooseHobbies (см. ниже) через список индексов,
        subjectCollection.get(0).click();                                    // но заморачиваться не стал, оставил только одно хобби.

        return this;
    }

    public DemoQARegistration chooseHobbies(int... hobbie) {                           // Вот тут поспрашивал у нейросети
        for (int index : hobbie) {                                           // как выбрать один ИЛИ несколько чекбоксов
            $("#hobbies-checkbox-%s".formatted(index)).click();              // чтобы не писать три метода. %s - добавил как ты научил.
        }
        return this;
    }

    public DemoQARegistration uploadPicture() {
        picture.uploadFromClasspath("obezgan.jpg");

        return this;
    }

    public DemoQARegistration setCurrentAddress(String Address) {
        currentAddress.setValue(Address);

        return this;
    }

    public DemoQARegistration chooseStateAndCity(String yourState, String yourCity) {
        chooseState.click();
        $(byText(yourState)).click();
        chooseCity.click();
        $(byText(yourCity)).click();

        return this;
    }
}
