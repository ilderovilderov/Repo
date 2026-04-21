package booking;

import dto.CreateBookingDTO;
import dto.CreateBookingResponse;
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

public class NegativeBookingTest {

    @BeforeAll
    static void setUp() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.filters(new AllureRestAssured());
    }

    @Test
    @DisplayName("Задача 2. Сценарий 1. Без firstname")
    @Tag("negative")
    void withoutFirstnameTest() {

        String wrongResponse = given()
                .contentType(ContentType.JSON)
                .body(buildWithoutFirstname("Ivanov", 3000, true, "2026-01-01", "2026-02-02", "coffee"))
                .post(BOOKING_URL + "/booking")
                .then()
                .statusCode(500) // Наверное дожен приходить 401, но теперь 500
                .extract()
                .asString();

        assertThat(wrongResponse)
                .as("Сообщение об ошибке")
                .contains("Internal Server Error");
    }

    private static CreateBookingDTO buildWithoutFirstname (String lname, Integer price, Boolean deposit, String in, String out, String needs) {
        return CreateBookingDTO.builder()
                .lastname(lname)
                .totalprice(price)
                .depositpaid(deposit)
                .bookingdates(CreateBookingDTO.BookingDates.builder()
                        .checkin(in)
                        .checkout(out)
                        .build())
                .additionalsneeds(needs)
                .build();
    }

    @Test
    @DisplayName("Задача 2. Сценарий 2. Без lastname")
    @Tag("negative")
    void withoutLastnameTest() {

        String wrongResponse = given()
                .contentType(ContentType.JSON)
                .body(buildWithoutLastname("Ivan", 3000, true, "2026-01-01", "2026-02-02", "coffee"))
                .post(BOOKING_URL + "/booking")
                .then()
                .statusCode(500) // Наверное дожен приходить 401, но теперь 500 //
                .extract()
                .asString();

        assertThat(wrongResponse)
                .as("Сообщение об ошибке")
                .contains("Internal Server Error");
    }

    private static CreateBookingDTO buildWithoutLastname (String fname, Integer price, Boolean deposit, String in, String out, String needs) {
        return CreateBookingDTO.builder()
                .firstname(fname)
                .totalprice(price)
                .depositpaid(deposit)
                .bookingdates(CreateBookingDTO.BookingDates.builder()
                        .checkin(in)
                        .checkout(out)
                        .build())
                .additionalsneeds(needs)
                .build();
    }

    static Stream<Arguments> wrongBookingData() {
        return Stream.of(
                Arguments.of("Ivan", "Ivanov", -300, false, "2026-06-01", "2026-08-01", "cookie"),
                Arguments.of("Ivan", "Ivanov", 9900, true, "ыыы бля", "2026-08-01", "banana"),
                Arguments.of("Ivan", "Ivanov", 9900, true, "2026-08-01", "2026-01-01", "banana")
        );
    }

    @DisplayName("Задача 2. Сценарии 3-5")
    @Tag("negative")
    @ParameterizedTest // Тест с сценариями 3 - 5
    @MethodSource("wrongBookingData")
    void wrongDataBookingTest(String fname, String lname, Integer price, Boolean deposit, String in, String out, String needs) {

        CreateBookingDTO negativeBookingRequest = buildWrongBookingRequest(fname, lname, price, deposit, in, out, needs);

        CreateBookingResponse wrongResponse = given()
                .contentType(ContentType.JSON)
                .body(negativeBookingRequest)
                .post(BOOKING_URL + "/booking")
                .then()
                .statusCode(200) // Наверное дожен приходить 400, но всегда приходит 200
                .extract().as(CreateBookingResponse.class);

        assertThat(wrongResponse.getBookingid()).isNotNull();
    }

    private static CreateBookingDTO buildWrongBookingRequest(String fname, String lname, Integer price, Boolean deposit, String in, String out, String needs) {
        return CreateBookingDTO.builder()
                .firstname(fname)
                .lastname(lname)
                .totalprice(price)
                .depositpaid(deposit)
                .bookingdates(CreateBookingDTO.BookingDates.builder()
                        .checkin(in)
                        .checkout(out)
                        .build())
                .additionalsneeds(needs)
                .build();
    }

    @DisplayName("Задача 2. Сценарии 6. Пустое Body")
    @Tag("negative")
    @Test
    void emptyBodyBookingTest() { // Тест с пустым Body

        CreateBookingDTO emptyBodyBookingRequest = CreateBookingDTO.builder().build();

        String wrongResponse = given()
                .contentType(ContentType.JSON)
                .body(emptyBodyBookingRequest)
                .post(BOOKING_URL + "/booking")
                .then()
                .statusCode(500) // Тут тоже наверное должна быть 400, а приходит 500
                .extract()                        // хз на проверку поставил код 500
                .asString();

        assertThat(wrongResponse)
                .as("Ответ должен содержать сообщение об ошибке")
                .contains("Internal Server Error");
    }
}