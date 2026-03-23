package webShop.steps;

import net.datafaker.Faker;
import webShop.pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static webShop.config.Config.WEB_SHOP_REGISTRATION_URL;

public class AuthSteps {
    private static final Faker faker = new Faker();

    public void registerNewUser() {
        open(WEB_SHOP_REGISTRATION_URL, RegistrationPage.class)
                .register(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.internet().emailAddress(),
                        faker.credentials().password());
    }

    private float getProcessorSurcharge(int processorIndex) {
        return switch (processorIndex) {
            case 0 -> 0f;      // slow - без надбавки
            case 1 -> 15f;     // medium - +15$
            case 2 -> 100f;    // fast - +100$
            default -> throw new IllegalArgumentException(
                    "Unknown processor index: " + processorIndex);
        };
    }
}
