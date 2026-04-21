package booking;

import dto.AuthRequest;
import dto.AuthResponse;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static webShop.config.Config.BOOKING_URL;

public class NegativeAuthTest {

    @BeforeAll
    static void setUp() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.filters(new AllureRestAssured());
    }

    static Stream<Arguments> wrongAuthData() {
        return Stream.of(
                Arguments.of("admin", "password"),
                Arguments.of("admin123", "password123"),
                Arguments.of("admin", ""),
                Arguments.of("", "")
        );
    }

    @DisplayName("Задача 1. Сценарии 1-5")
    @Tag("negative")
    @ParameterizedTest
    @MethodSource("wrongAuthData")
    void wrongAuthTest(String user, String password) {

        AuthResponse wrongResp = given()
                .contentType(ContentType.JSON)
                .body(new AuthRequest(user, password))
                .post(BOOKING_URL + "/auth")
                .then()
                .statusCode(200)   // тут можно ожидать 401, но пришли все 200
                .extract().as(AuthResponse.class);

        assertThat(wrongResp.getToken()).isNull(); //
    }

    @DisplayName("Задача 1. Сценарии 6. Без body")
    @Tag("negative")
    @Test
    void withoutBodyTest() {
        AuthResponse wrongResp = given()
                .contentType(ContentType.JSON)
                .post(BOOKING_URL + "/auth")
                .then()
                .statusCode(200) // тут можно ожидать 400, но снова пришел 200
                .extract().as(AuthResponse.class);

        assertThat(wrongResp.getToken()).isNull();
    }
}

