package booking;

import dto.AuthRequest;
import dto.AuthResponse;
import dto.CreateBookingDTO;
import dto.CreateBookingResponse;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class BookingTest {

    private static final String BOOKING_URL = "https://restful-booker.herokuapp.com";

    @BeforeAll
    static void setUp() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.filters(new AllureRestAssured());
    }


    @Test
    void authTest() {

        String user = "admin";
        String password = "password123";

        AuthResponse resp = given()
                .contentType(ContentType.JSON)
                .body(new AuthRequest(user, password))
                .post(BOOKING_URL + "/auth")
                .then()
                .statusCode(200)
                .extract().as(AuthResponse.class);

        assertThat(resp.getToken()).isNotNull();
    }

    @Test
    void createBookingTest() {
        CreateBookingResponse resp = given()
                .contentType(ContentType.JSON)
                .body(buildBookingRequest("Barack", "Obama", 1000, false, "2026-01-01", "2027-01-01", "newspaper"))
                .post(BOOKING_URL + "/booking")
                .then()
                .statusCode(200)
                .extract().as(CreateBookingResponse.class);

        assertThat(resp.getBookingid()).isNotNull();
        assertThat(resp.getBooking().getTotalprice()).isEqualTo(1000);
        assertThat(resp.getBooking().getBookingdates().getCheckin()).isEqualTo("2026-01-01");
        assertThat(resp.getBooking().getDepositpaid()).isFalse();
    }

    private static CreateBookingDTO buildBookingRequest(String fname, String lname, Integer price, Boolean deposit, String in, String out, String needs) {
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
}
