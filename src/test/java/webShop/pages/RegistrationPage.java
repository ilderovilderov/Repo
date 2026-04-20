package webShop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationPage {
    private final SelenideElement pageTitle = $("div.page-title");
    private final SelenideElement maleGenderRadio = $("input#gender-male");
    private final SelenideElement firstNameInput = $("input#FirstName");
    private final SelenideElement lastNameInput = $("input#LastName");
    private final SelenideElement emailInput = $("input#Email");
    private final SelenideElement passwordInput = $("input#Password");
    private final SelenideElement confirmPasswordInput = $("input#ConfirmPassword");
    private final SelenideElement submitRegostrationButton = $("input#register-button");
    private final SelenideElement resultText = $("div.result");
    private final ElementsCollection userEmailInHeader = $$("div.header-links ul li a");

    @Step("Заполнеие данных для регистрации пользователя: {name}, {surname}, {email}, {password}")
    public RegistrationPage register(String name, String surname, String email, String password) {
        selectMaleGender()
                .enterFirstName(name)
                .enterLastName(surname)
                .enterEmail(email)
                .enterPassword(password)
                .confirmPassword(password)
                .submitRegistration()
                .checkRegistrationCompleted();
        return this;
    }

    @Step("Проверка нахождения на странице регистрации")
    public RegistrationPage verifyRegistrationOpened() {
        pageTitle.shouldHave(text("Register"));
        return this;
    }

    @Step("Выбор пола")
    public RegistrationPage selectMaleGender() {
        maleGenderRadio.click();
        return this;
    }

    @Step("Заполнение строки с именем: {name}")
    public RegistrationPage enterFirstName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    @Step("Заполнение строки с фамилией: {surname}")
    public RegistrationPage enterLastName(String surname) {
        lastNameInput.setValue(surname);
        return this;
    }

    @Step("Заполнение строки с электронной почтой: {email}")
    public RegistrationPage enterEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Заполнение строки с паролем: {password}")
    public RegistrationPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Заполнение строки с подтверждением пароля: {password}")
    public RegistrationPage confirmPassword(String password) {
        confirmPasswordInput.setValue(password);
        return this;
    }

    @Step("Подтверждение регистрации")
    public RegistrationPage submitRegistration() {
        submitRegostrationButton.click();
        return this;
    }

    @Step("Проверка надписи об успешном прохождении регистрации")
    public WelcomePage checkRegistrationCompleted() {
        resultText.shouldHave(text("Your registration completed"));
        return new WelcomePage();
    }

    @Step("Проверка корректного отображения email после регистрации: {email}")
    public RegistrationPage checkUserLoginIn(String email) {
        userEmailInHeader.get(0).shouldHave(text(email));
        return this;
    }
}
