package MMT_Objects.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LocatorUtil {
    private Properties properties;
    public LocatorUtil(String filePath) {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public By getLocator(String key) {
        String locator = properties.getProperty(key);
        if (locator.startsWith("id:")) {
            return By.id(locator.substring(3));
        } else if (locator.startsWith("xpath:")) {
            return By.xpath(locator.substring(6));
        } else {
            // Default to XPath if no type specified
            return By.xpath(locator);
        }
    }

}
