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
    //Hashmap to store property values
    public Map<String, String> prop = new HashMap<String, String>();

    /**
     * fetching application base url, username form testng.xml file
     *
     * @param context
     */
    @BeforeSuite
    public void beforeClass(ITestContext context) {
        RestAssured.baseURI = context.getCurrentXmlTest().getParameter("BaseURI");
        userName = context.getCurrentXmlTest().getParameter("UserName");
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
