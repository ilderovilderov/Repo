package jUnit;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void before() {
        Configuration.browserSize = "2560x1440";
    }

    @BeforeEach
    void closeDriver() {
        closeWebDriver();
    }
}