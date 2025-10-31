package autotests.test.get;

import autotests.BaseTest;
import autotests.Directory;
import framework.web.HttpStatusCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class FlyMethodTests extends BaseTest {
    private static final String url = Directory.FLY.getValue();

    @Test
    @DisplayName("Проверка метода \"Лететь\" в случае, если состояние крыльев - ACTIVE")
    public void checkFLyMethodWhenWingsAreActive() {
        //prepare
        String expectedMessage = "I'm flying";

        // do
        String actualMessage = given()
                .spec(requestSpecification)
                .when()
                .queryParam("wingsState", "ACTIVE")
                .get(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("message");

        // check
        assertEquals(expectedMessage, actualMessage);
    }
}

