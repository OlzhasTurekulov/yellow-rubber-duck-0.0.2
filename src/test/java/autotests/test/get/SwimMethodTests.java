package autotests.test.get;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import autotests.BaseTest;
import autotests.Directory;
import framework.web.HttpStatusCode;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwimMethodTests extends BaseTest {
    private static final String url = Directory.SWIM.getValue();

    @Test
    @DisplayName("Проверка метода \"Плыть\"")
    public void checkSwimMethod() {
        //prepare
        String expectedMessage = "";

        // do
        String actualMessage = given()
                .spec(requestSpecification)
                .when()
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

