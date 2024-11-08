package MMT_Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
        //popup msg
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement closeButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='commonModal__close']")));
        closeButton.click();

        Thread.sleep(5000);
        driver.findElement(By.id("fromCity")).click();
        driver.findElement(By.xpath("//input[@aria-controls='react-autowhatever-1']")).sendKeys("new delhi");
    }
}
