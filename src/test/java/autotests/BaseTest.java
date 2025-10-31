package autotests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

public class BaseTest {
    private static String baseURI = "";
    public static RequestSpecification requestSpecification;

    @BeforeAll
    public static void initialize() throws Exception {
        Properties properties = new Properties();
        properties.load(
                new FileInputStream(
                        Objects.requireNonNull(
                                        Thread.currentThread()
                                                .getContextClassLoader()
                                                .getResource("env.properties"))
                                .toURI()
                                .getPath()));

        baseURI = properties.getProperty("yellow-rubber-duck-url");

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseURI)
                .setBasePath(BasePath.DUCK.getValue())
                .build();
    }
}
