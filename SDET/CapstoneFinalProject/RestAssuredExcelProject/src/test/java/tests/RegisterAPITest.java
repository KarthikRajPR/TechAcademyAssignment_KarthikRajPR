package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ExcelUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class RegisterAPITest {
    String email,password;

    @BeforeTest
    public void getEmail() throws IOException {
        email = ExcelUtils.getCellData("Sheet1", 1, 0);
    }

    @BeforeTest
    public void getPassword() throws  IOException{
        password = ExcelUtils.getCellData("Sheet1", 1, 1);
    }

    @Test
    public void registerPositiveScenario() throws IOException {
        RestAssured.baseURI = "https://reqres.in";
        System.out.println("The email id used for the test is "+email);

        Response response = given()
                .header("Content-Type", "application/json")
                .header("x-api-key","reqres-free-v1")
                .body("{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }")
                .when()
                .post("/api/register")
                .then()
                .statusCode(200)
                .extract()
                .response();

        if(response.statusCode()==200){
            System.out.println("Status success "+response.statusCode());
        }
        else{
            System.out.println("Failed to proceed "+response.statusCode());
        }
        int id = response.jsonPath().getInt("id");
        String token = response.jsonPath().getString("token");

        //Validation using Assert
        Assert.assertTrue(id>0, "Id should be an integer greater than 0");
        Assert.assertTrue(id instanceof Integer, "Id should be an integer greater than 0");
        Assert.assertNotNull(token, "Token should not be null");
        Assert.assertTrue(token instanceof String, "Token should be a string");
    }

    @Test
    public void registerNegativeScenario() throws Exception {
        String email = ExcelUtils.getCellData("Sheet1", 2, 0);
        String password = ExcelUtils.getCellData("Sheet1", 2, 1);

        RestAssured.baseURI = "https://reqres.in";

        Response response = given()
                .header("x-api-key","reqres-free-v1")
                .body("{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }")
                .when()
                .post("/api/register")
                .then()
                .statusCode(400)
                .extract()
                .response();

        String errorMessage = response.jsonPath().getString("error");
        Assert.assertNotNull(errorMessage, "Error message should be returned for negative case");
    }
}
