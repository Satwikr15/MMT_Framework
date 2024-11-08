package MMT_Objects.BaseClass;

import MMT_Objects.Pages.SearchFlights;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
/**
 * This Base class contains Browser setup and navigating to Home page of "Make my trip" Website
 * */
public class Base_Class {
    WebDriver driver;
    public SearchFlights sfo;
    public void browsersetup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com");

        //popup msg
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement closeButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='commonModal__close']")));
        closeButton.click();

        sfo=new SearchFlights(driver);
    }
}
