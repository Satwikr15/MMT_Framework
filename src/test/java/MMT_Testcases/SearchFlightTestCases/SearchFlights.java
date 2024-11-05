package MMT_Testcases.SearchFlightTestCases;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchFlights extends Base_Class {
    WebDriver driver;

    public SearchFlights(WebDriver driver) {
    this.driver=driver;
    }

    By Flightmode=By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chFlights active']");

    By OneWayTrip=By.xpath("//ul//li[@data-cy='roundTrip']");

    By FromCity=By.id("fromCity");
    By FromAirport=By.xpath("//p[text()='New Delhi, India']"); //New Delhi, India // Pune Airport

    By ToCity=By.id("toCity");
    By ToAirport=By.xpath("//p[text()='Mumbai, India']");

    By DepartureDate=By.xpath("//div[@aria-label='Sat Nov 16 2024']");
    By ReturnDate=By.xpath("//div[@aria-label='Sat Dec 07 2024']");

    By TravelClassBtn=By.xpath("//span[@class='lbl_input appendBottom5']");
    By TravelClassB=By.xpath("//li[3][@data-cy='travelClass-2']");
    By TravelClassApply=By.xpath("//button[@data-cy='travellerApplyBtn']");

    By SpecialFare=By.xpath("//div[@style='background-color: rgb(234, 245, 255); border-color: rgb(0, 140, 255);']"); //student

    By SearchBtn=By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']");
    public void Check_FlightMode(){
        WebElement flight=driver.findElement(Flightmode);
        flight.click();
    }

    public void TypeofTrip(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement roundTripElement = wait.until(ExpectedConditions.visibilityOfElementLocated(OneWayTrip));
        roundTripElement.click();
    }

    public void FromCity() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement fromcity=wait.until(ExpectedConditions.visibilityOfElementLocated(FromCity));
        fromcity.sendKeys("Pune");

        //scroll down the dropdown list
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-autowhatever-1\"]")));
        boolean optionFound = false;
        while (!optionFound) {
            try {
                // Try to locate and click the desired option
                WebElement fromairport = driver.findElement(FromAirport);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fromairport);
                fromairport.click();
                optionFound = true; // Exit loop if click is successful
            } catch (NoSuchElementException e) {
                // Scroll down if the option is not yet in view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop += 50;", dropdown);
                Thread.sleep(500); // Adjust sleep time as needed
            }
        }

//        driver.findElement(FromCity).sendKeys("Pune");
//        driver.findElement(FromAirport).click();
    }

    public void ToCity() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement tocity=wait.until(ExpectedConditions.visibilityOfElementLocated(ToCity));
        tocity.sendKeys("Mumbai");

        //scroll down the dropdown list
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-autowhatever-1\"]")));
        boolean optionFound = false;
        while (!optionFound) {
            try {
                // Try to locate and click the desired option
                WebElement toairport = driver.findElement(ToAirport);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", toairport);
                toairport.click();
                optionFound = true; // Exit loop if click is successful
            } catch (NoSuchElementException e) {
                // Scroll down if the option is not yet in view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop += 50;", dropdown);
                Thread.sleep(500); // Adjust sleep time as needed
            }
        }

//        driver.findElement(ToCity).sendKeys("Mumbai");
//        driver.findElement(ToAirport).click();
    }

    public void BookingDates() throws InterruptedException {

        Thread.sleep(3000);
        driver.findElement(DepartureDate).click();
        driver.findElement(ReturnDate).click();
    }

    public void Travelclass() throws InterruptedException {
        driver.findElement(TravelClassBtn).click();
        Thread.sleep(2000);
        driver.findElement(TravelClassB).click();
        System.out.println("Bussiness class selected");
        //Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(TravelClassApply));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        driver.findElement(TravelClassApply).click();

    }

    public void Specialfare(){
        driver.findElement(SpecialFare).click();
    }

    public void Searchbtn(){
        driver.findElement(SearchBtn).click();
        System.out.println("Today's task completed");
    }
}
