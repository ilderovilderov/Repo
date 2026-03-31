package webShop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import jUnit.TestBase;
import webShop.pages.WelcomePage;

import static com.codeborne.selenide.Selenide.*;
import static webShop.config.Config.WEB_SHOP_URL;

public class RegistrationTest extends TestBase {
    private static final Faker faker = new Faker();

    @Test
    void registrationTest() {
        String password = faker.credentials().password();
        String email = faker.internet().emailAddress();
        String name = faker.name().firstName();
        String surname = faker.name().lastName();

        open(WEB_SHOP_URL, WelcomePage.class)
                .openRegistration()
                .verifyRegistrationOpened()
                .selectMaleGender()
                .enterFirstName(name)
                .enterLastName(surname)
                .enterEmail(email)
                .enterPassword(password)
                .confirmPassword(password)
                .submitRegistration()
                .checkRegistrationCompleted()
                .checkUserLoginIn(email);
    }
}
