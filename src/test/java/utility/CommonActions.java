package utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CommonActions {
    /**
     * Fetching values from property file
     */
    public static String userContext = new config().getProperrty("contextUser");
    public static String PostContext = new config().getProperrty("contextPost");
    public static String commentContext = new config().getProperrty("contextComments");


    public static Response performGet(String context, String queryParam, Object paramValue) {
        Response response = given().queryParam(queryParam, paramValue).when().get(context);
        response.then().statusCode(200);
        System.out.println("Performing get to " + RestAssured.baseURI + context + "?" + queryParam + "=" + paramValue);
        return response;
    }

    public static boolean validateEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}
