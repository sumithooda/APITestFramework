package common;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import utility.config;

import java.util.HashMap;
import java.util.Map;

public class TestBase {

    public String userName;
    public String invalidusername;
    //Hashmap to store property values
    public Map<String, String> prop = new HashMap<String, String>();

    /**
     * fetching application base url, username form testng.xml file
     *
     * @param context
     */
    @BeforeClass
    public void beforeClass(ITestContext context) {
        String baseUri = context.getCurrentXmlTest().getParameter("BaseURI");
        RestAssured.baseURI = baseUri;
        Reporter.log("BaseURI " + baseUri, true);
        userName = context.getCurrentXmlTest().getParameter("validUserName");
        invalidusername=context.getCurrentXmlTest().getParameter("invalidUserName");
        Reporter.log("userName " + userName, true);
        getProperties();
    }

    /**
     * Load properties to hashMap
     */
    public void getProperties() {
        for (final Map.Entry<Object, Object> entry : config.getProperties().entrySet()) {
            prop.put((String) entry.getKey(), (String) entry.getValue());
        }
    }
}
