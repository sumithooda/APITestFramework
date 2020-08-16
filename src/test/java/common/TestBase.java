package common;

import io.restassured.RestAssured;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.ITestContext;

public class TestBase {

    public String userName;
    /**
     * fetching application base url, username form testng.xml file
     * @param context
     */
    @BeforeClass
    public void beforeClass(ITestContext context) {
        RestAssured.baseURI = context.getCurrentXmlTest().getParameter("BaseURI");
        userName=context.getCurrentXmlTest().getParameter("UserName");
        Reporter.log("", true);
    }

}
