package booking;

import dto.AuthRequest;
import dto.AuthResponse;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BookingTest {

    private static final String BOOKING_URL = "https://restful-booker.herokuapp.com";

    @BeforeAll
    static void setUP() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }


    @Test
    void authTest() {

        String user = "admin";
        String password = "password123";

        AuthRequest request = new AuthRequest();
        request.setUsername(user);
        request.setPassword(password);

        AuthResponse resp = given()
                .body(request)
                .when()
                .post(BOOKING_URL + "/auth")
                .then()
                .statusCode(200)
                .extract().as(AuthResponse.class);

    }
}
