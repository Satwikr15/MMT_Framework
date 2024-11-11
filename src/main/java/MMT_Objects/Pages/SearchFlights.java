package MMT_Objects.Pages;

import MMT_Objects.BaseClass.Base_Class;
import MMT_Objects.Utils.LocatorUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * It is a Page object model class which contains only locaters and Methods
 * */
public class SearchFlights extends Base_Class {
    WebDriver driver;
    private LocatorUtil locatorUtil;

    public SearchFlights(WebDriver driver) {
    this.driver=driver;
        this.locatorUtil = new LocatorUtil("src/main/java/MMT_Objects/Locators.properties");
    }

//    By Flightmode=By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chFlights active']");
//
//    By OneWayTrip=By.xpath("//ul//li[@data-cy='roundTrip']");
//
//    By FromCity=By.id("fromCity");
//    By ToCity=By.id("toCity");
//    By SearchBar=By.xpath("//input[@aria-controls='react-autowhatever-1']");
//    By Suggested_city =By.xpath("//div[@class='makeFlex appendTop12  forHideundefined']");
//
//    By TravelClassBtn=By.xpath("//span[@class='lbl_input appendBottom5']");
//    By TravelClassApply=By.xpath("//button[@class='primaryBtn btnApply pushRight']");
//
//    By SearchBtn=By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']");


    public void Check_FlightMode(){
        WebElement flight=driver.findElement(locatorUtil.getLocator("Flightmode"));
        flight.click();
    }

    public void TypeofTrip(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By OneWayTripLocator =locatorUtil.getLocator("OneWayTrip");
        WebElement roundTripElement = wait.until(ExpectedConditions.visibilityOfElementLocated(OneWayTripLocator));
        roundTripElement.click();
    }

    public void chooseBoardingAndDestination(String fromcity,String tocity) throws InterruptedException {
        Selectcity(locatorUtil.getLocator("FromCity"),fromcity);
        Selectcity(locatorUtil.getLocator("ToCity"),tocity);
    }
    public void Selectcity(By cityLocator,String cityname) throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2000));
        driver.findElement(cityLocator).click();
        Thread.sleep(2000);
        driver.findElement(locatorUtil.getLocator("SearchBar")).sendKeys(cityname);
        WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(locatorUtil.getLocator("Suggested_city")));
        suggestion.click();
    }
    public void BookingDates(String FromDate,String ToDate) throws InterruptedException {

        Thread.sleep(5000);
        SelectingDates(FromDate);
        SelectingDates(ToDate);
    }
    public void SelectingDates(String Date){
        driver.findElement(By.xpath("//div[contains(@aria-label,'" + Date + "')]")).click();

    }

public void Travelclass(String adults, String children, String infants,String travelclass) throws InterruptedException {
    // Open the travel class selection
    driver.findElement(locatorUtil.getLocator("TravelClassBtn")).click();
    Thread.sleep(2000);

    // Call the SelectPassengers method to choose the number of passengers like adults,children,infants and selecting travelclass
    SelectPassengers(adults, children, infants,travelclass);

    // Scroll to the 'Apply' button
    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebElement applyButton = driver.findElement(locatorUtil.getLocator("TravelClassApply"));
    js.executeScript("arguments[0].scrollIntoView(true);", applyButton); // Scroll to the element
    js.executeScript("window.scrollBy(0, 100);");
    Thread.sleep(2000);
    // Extra scrolling if needed
    // Wait until the 'Apply' button is clickable, then click it
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    wait.until(ExpectedConditions.elementToBeClickable(locatorUtil.getLocator("TravelClassApply"))).click();
}

    // Method for selecting passengers
    public void SelectPassengers(String adults, String children, String infants, String travelclass) {
        // Select the number of adults
        String dynamicXPath_Adults = "//ul[@class='guestCounter font12 darkText gbCounter']//li[@data-cy='adults-" + adults + "']";
        WebElement adultOption = driver.findElement(By.xpath(dynamicXPath_Adults));
        adultOption.click();

        // Select the number of children
        String dynamicXPath_Children = "//ul[@class='guestCounter font12 darkText gbCounter']//li[@data-cy='children-" + children + "']";
        WebElement childrenOption = driver.findElement(By.xpath(dynamicXPath_Children));
        childrenOption.click();

        // Select the number of infants
        String dynamicXPath_Infants = "//ul[@class='guestCounter font12 darkText gbCounter']//li[@data-cy='infants-" + infants + "']";
        WebElement infantsOption = driver.findElement(By.xpath(dynamicXPath_Infants));
        infantsOption.click();

        String dynamicXPath_TravelClass="//ul[@class='guestCounter classSelect font12 darkText']//li[contains(text(),'"+travelclass +"')]";
        WebElement TravelClassOption=driver.findElement(By.xpath(dynamicXPath_TravelClass));
        TravelClassOption.click();
    }

    public void Specialfare(String special_fare){
        String dynamicXPath_Specialfare="//div[contains(@class, 'white-space-no-wrap blackText latoBold lineHeight18 darkGreyText appendBottom3') and contains(text(), '"+special_fare+"')]";
        driver.findElement(By.xpath(dynamicXPath_Specialfare)).click();
    }

    public void Searchbtn(){
        driver.findElement(locatorUtil.getLocator("SearchBtn")).click();
        System.out.println("Today's task completed");
    }
}
