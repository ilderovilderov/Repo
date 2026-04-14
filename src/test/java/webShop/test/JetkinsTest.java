package webShop.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class JetkinsTest {

    @Test
    @Tags({@Tag("UI"), @Tag("positive")})
    @DisplayName("UI positive")
    void jetkinsTest1() {
        System.out.println("UI positive test");
    }

    @Test
    @Tags({@Tag("UI"), @Tag("negative")})
    @DisplayName("UI negative")
    void jetkinsTest2() {
        System.out.println("UI negative test");
    }

    @Test
    @Tags({@Tag("API"), @Tag("positive")})
    @DisplayName("API positive")
    void jetkinsTest3() {
        System.out.println("API positive test");
    }

    @Test
    @Tags({@Tag("API"), @Tag("negative")})
    @DisplayName("API negative")
    void jetkinsTest4() {
        System.out.println("API negative test");
    }
}
