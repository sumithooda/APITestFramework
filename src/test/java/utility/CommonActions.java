package utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CommonActions {

    Response perfromGet(String context, String queryParam, String paramValue){
        Response response = given().queryParam(queryParam,paramValue).when().get("/"+context+"");
        response.then().statusCode(200);
        System.out.println("Performing get to" + RestAssured.baseURI + context);
        return response;
    }
    public static boolean validateEmail(String email){
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}
