package webShop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import jUnit.TestBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import webShop.pages.RegistrationPage;
import webShop.pages.WelcomePage;

import static com.codeborne.selenide.Selenide.*;
import static webShop.config.Config.WEB_SHOP_REGISTRATION_URL;
import static webShop.config.Config.WEB_SHOP_URL;

public class LoginTest extends TestBase {
    private static final Faker faker = new Faker();
    private String password;
    private String email;
    private String name;
    private String surname;

    @BeforeEach
    void beforeEach() {
        password = faker.credentials().password();
        email = faker.internet().emailAddress();
        name = faker.name().firstName();
        surname = faker.name().lastName();

        open(WEB_SHOP_REGISTRATION_URL, RegistrationPage.class)
                .register(
                        name,
                        surname,
                        email,
                        password)
                .checkUserLoginIn(email);

        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @Test
    @Disabled ("Есть парамТест ниже")
    void successLoginTest() {

        open(WEB_SHOP_URL, WelcomePage.class)
                .openLogin()
                .checkLoginPageOpened()
                .setEmail(email)
                .setPassword(password)
                .rememberMeCheckBox()
                .loginIn()
                .checkUserLoginIn(email);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/email.csv")
    void invalidEmailLoginTest(String email) {
        open(WEB_SHOP_URL, WelcomePage.class)
                .openLogin()
                .setEmail(email)
                .setPassword(password)
                .verifyEmailValidationAppear()
                .loginIn();
    }
}
