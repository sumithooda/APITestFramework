package tests;

import common.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.CommonActions;

public class sanityTest extends TestBase {

    /**
     * Validate response for non exist user
     */
    @Test
    public void verifyResponseForNonExistdata() {
        Response response = CommonActions.performGet(prop.get("contextUser"), "username", invalidusername);
        response.then().assertThat().statusCode(200);
        Assert.assertTrue(response.getBody().asString().equals("[]"),"Body is not empty for user "+invalidusername);
    }

    /**
     * Validate response for invalid context
     */
    @Test
    public void verifyResponseForNonExistUrl() {
        Response response = CommonActions.performGet("userks", "username", userName);
        response.then().assertThat().statusCode(404);
        Assert.assertTrue(response.getBody().asString().equals("{}"),"Body is not empty for user "+invalidusername);
    }
}
