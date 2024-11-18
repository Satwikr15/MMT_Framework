package MMT_Objects.Utils;

import MMT_Objects.BaseClass.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitUtil{
    WebDriver driver;
    public WaitUtil(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementWithFluentWait(By locator, int timeoutSeconds, int pollingSeconds) {
        // Create a Fluent Wait instance
        Wait<WebDriver> fluentWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofSeconds(pollingSeconds))
                .ignoring(NoSuchElementException.class);

        // Define the condition to check if the element is visible
        return fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                return element.isDisplayed() ? element : null;
            }
        });
    }
}
