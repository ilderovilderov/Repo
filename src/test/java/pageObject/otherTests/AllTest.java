package pageObject.otherTests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jUnit.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.SeverityLevel.*;

public class AllTest extends TestBase {

    @Test
    @Tag("positive")
    @DisplayName("Успешное заполнение формы на сайте")
    @Severity(CRITICAL)
    @Owner("@ilderovilderov")
    @Link(name = "TASK-004")
    void DemoQaTest() {

        Configuration.holdBrowserOpen=true;               // оставил
        Configuration.browserSize = "1920x1080";

      open("https://demoqa.com/automation-practice-form", DemoQARegistration.class)
              .setFirstName("Alexander")
              .setLastName("Test")
              .setEmail("alexander@test.int")
              .setPhoneNumber("9930900333")
              .chooseGender(2)
              .setBirthDate("1996", "May", 20 )
              .chooseSubjects("Commerce", "Math", "Arts")
              .chooseHobbies(2, 1)
              .uploadPicture()
              .setCurrentAddress("WWW LENINGRAD SBP TOCHKA RU")
              .chooseStateAndCity("NCR", "Delhi")
              .submit()
              .verify();
    }

    @Test
    @DisplayName("Успешное проведение заказа")
    @Severity(CRITICAL)
    @Owner("@ilderovilderov")
    @Link(name = "TASK-005")
    void SwagLabsShopTest() {

        Configuration.holdBrowserOpen=true;                // оставил
        Configuration.browserSize = "1920x1080";

        open("https://www.saucedemo.com/", SwagLabsShop.class)
                .inputUsername("standard_user")
                .inputPassword("secret_sauce")
                .loginIN()
                .chooseBikeLight()
                .makeOrder()
                .setPersonalData("Ivan", "Petrov", "435677")
                .continueOrder()
                .submit()
                .verify();
    }
}
