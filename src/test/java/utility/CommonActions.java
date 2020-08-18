package utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Reporter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;

public class CommonActions {

    /**
     * Perform Get operation
     *
     * @param context context for resource
     * @param queryParam query parameters for call
     * @param paramValue parameter value
     * @return response
     */
    public static Response performGet(String context, String queryParam, Object paramValue) {
        Response response = given().queryParam(queryParam, paramValue).when().get(context);
        Reporter.log("Performing get to " + RestAssured.baseURI + context + "?" + queryParam + "=" + paramValue,true);
        return response;
    }

    /**
     * Validate email format
     *
     * @param email for format validation from comment call
     * @return boolean as per result
     */
    public static boolean validateEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
