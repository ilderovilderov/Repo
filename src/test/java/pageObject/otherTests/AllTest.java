package pageObject.otherTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AllTest {

    @Test
    void DemoQaTest() {

        Configuration.holdBrowserOpen=true;                // оставил
        Configuration.browserSize = "1920x1080";

      open("https://demoqa.com/automation-practice-form", DemoQARegistration.class)
              .setFirstName("Alexander")
              .setLastName("Test")
              .setEmail("alexander@test.int")
              .setPhoneNumber("9930900333")
              .chooseGender(2)
              .setBirthDate("1996", "May", 20 )
              .chooseSubjects("Acco")
              .chooseHobbies(2, 1)
              .uploadPicture()
              .setCurrentAddress("WWW LENINGRAD SBP TOCHKA RU")
              .chooseStateAndCity("NCR", "Delhi");

        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }


    @Test
    void SwagLabsShopTest() {
        Configuration.holdBrowserOpen=true;                // оставил
        Configuration.browserSize = "1920x1080";

        // Логимимся, выбираем товар, делаем заказ и убеждаемся, что заказ сделан

        open("https://www.saucedemo.com/", SwagLabsShop.class)
                .inputUsername("standard_user")
                .inputPassword("secret_sauce")
                .chooseBikeLight()
                .makeOrder()
                .setPersonalData("Ivan", "Petrov", "435677");

        $("#finish").click();
        $(".complete-header").shouldHave(text("Thank you for your order!"));
    }
}
