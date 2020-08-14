package tests;

import common.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class IntegrationTest extends TestBase {

    @Test
    public void findUser(){
        given().queryParam("username",userName).when().get("/users").then().statusCode(200);
    }
}
