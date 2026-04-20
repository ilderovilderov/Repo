package webShop.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class APITest {

    @Test
    @Tags({@Tag("API"), @Tag("positive")})
    @DisplayName("API positive")
    void jetkinsTest1() {
        System.out.println("API positive test");
    }

    @Test
    @Tags({@Tag("API"), @Tag("negative")})
    @DisplayName("API negative")
    void jetkinsTest2() {
        System.out.println("API negative test");
    }
}
