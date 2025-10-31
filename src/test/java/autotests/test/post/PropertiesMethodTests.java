package autotests.test.post;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import autotests.payload.MaterialProperties;
import autotests.response.DuckProperties;
import autotests.BaseTest;
import autotests.Directory;
import framework.web.HttpStatusCode;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertiesMethodTests extends BaseTest {
    private static final String url = Directory.PROPERTIES.getValue();

    @Test
    @DisplayName("Проверка цвета уточки в случае, если материал - резина")
    public void checkColorWhenMaterialIsRubber() {
        //prepare
        MaterialProperties body = new MaterialProperties()
                .material("rubber");

        String expectedColor = "yellow";

        // do
        String actualColor = given()
                .spec(requestSpecification)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("color");

        // check
        assertEquals(expectedColor, actualColor);
    }

    @Test
    @DisplayName("Проверка свойств уточки в случае, если материал - резина")
    public void checkPropertiesWhenMaterialIsRubber() {
        //prepare
        MaterialProperties body = new MaterialProperties()
                .material("rubber");

        DuckProperties expectedDuckProperties = new DuckProperties()
                .material("rubber")
                .color("yellow")
                .metersHeight(0.03);

        // do
        DuckProperties actualDuckProperties = given()
                .spec(requestSpecification)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .body()
                .as(DuckProperties.class);

        // check
        assertEquals(expectedDuckProperties, actualDuckProperties);
    }

}

