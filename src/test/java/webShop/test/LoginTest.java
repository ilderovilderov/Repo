package webShop.test;

import io.qameta.allure.*;
import net.datafaker.Faker;
import org.junit.jupiter.api.*;
import jUnit.TestBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import webShop.pages.LoginPage;
import webShop.pages.RegistrationPage;
import webShop.pages.WelcomePage;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static webShop.config.Config.*;

public class LoginTest extends TestBase {
    private static final Faker faker = new Faker();
    private String password;
    private String email;
    private String name;
    private String surname;

    @Nested
    public class PositiveTests {
        @BeforeEach
        @Owner("ilderovilderov")
        @Tag("positive")
        @Severity(CRITICAL)
        @Epic("Авторизация")
        @Feature("Регистрация")
        @Story("Регистрация нового пользователя")
        @Link("TASK-007")
        // @Issue("BUG-19") //- описание проблемы если тест @Disabled
        @DisplayName("Успешная регистрация нового пользователя")
        @Description("Создаем нового пользователя со случайными данными через интерфейс")
        void userRegistrationTest() {
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
        @Disabled("Есть парамТест ниже")
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
    }


    @ParameterizedTest(name = "Авторизация с невалидным Email: {0}")
    @Owner("ilderovilderov")
    @Tag("negative")
    @Severity(NORMAL)
    @Epic("Авторизация")
    @Feature("Вход в личный кабинет")
    @Story("Авторизация пользователя с невалидными данными")
    @Link("TASK-008")
    @CsvFileSource(resources = "/email.csv")
    void invalidEmailLoginTest(String email) {
        open(WEB_SHOP_LOGIN_URL, LoginPage.class)
                .setEmail(email)
                .setPassword("password")
                .verifyEmailValidationAppear()
                .loginIn();
    }
}
