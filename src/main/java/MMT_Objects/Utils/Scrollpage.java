package MMT_Objects.Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;

public class Scrollpage {
    WebDriver driver;
    LocatorUtil locatorUtil;
    public Scrollpage(WebDriver driver){
        this.driver=driver;
    }
    public void Scrolltilloffset(By element, int offset){
        WebElement element1=driver.findElement(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element1); // Scroll to the element
        js.executeScript("window.scrollBy(0, arguments[0]);", offset);
    }
}
