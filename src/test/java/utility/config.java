package utility;

import org.testng.Reporter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class to read properties file
 */
public class config {
    public static Properties getProperties() {
        Properties properties = new Properties();
        InputStream input = null;
        try {
            String resourceFile = "src/test/resources/JsonPlaceHolder.properties";
            properties.load(new FileInputStream(resourceFile));
        } catch (IOException e) {
            Reporter.log("Load property issue", true);
            e.printStackTrace();
        } finally {
            if (input != null) {
                Reporter.log("Read property complete", true);
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }
}
