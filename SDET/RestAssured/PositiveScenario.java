import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static com.testio.Matchers.*;
import org.junit.jupiter.api.Test;

public class PositiveScenario {

    @Test
    public void testValidCapital() {
        RestAssured.baseURI = "https://restcountries.com/v3.1/capital";

        given()
        .when()
            .get("/tallinn")
        .then()
            .statusCode(200)
            .body("[0].name.common", equalTo("Estonia"));
    }