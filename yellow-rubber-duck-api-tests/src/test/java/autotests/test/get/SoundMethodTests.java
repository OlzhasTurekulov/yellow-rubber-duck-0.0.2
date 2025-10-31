package autotests.test.get;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import autotests.BaseTest;
import autotests.Directory;
import framework.web.HttpStatusCode;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SoundMethodTests extends BaseTest {
    private static final String url = Directory.SOUND.getValue();

    @Test
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - 1, количество звуков - 1")
    public void checkFLyMethodWhenWingsAreActive() {
        //prepare

        HashMap<String, Object> queryParams = new HashMap<>() {{
            put("repetitionCount", 1);
            put("soundCount", 1);
        }};
        String expectedSound = "quack";

        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("sound");

        // check
        assertEquals(expectedSound, actualSound);
    }
}

