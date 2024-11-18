package MMT_Objects.Pages;

import MMT_Objects.BaseClass.Base_Class;
import MMT_Objects.Utils.LocatorUtil;
import MMT_Objects.Utils.Scrollpage;
import MMT_Objects.Utils.WaitUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

/**
 * It is a Page object model class which contains only locaters and Methods
 * */
public class SearchFlights_PO extends Base_Class {
    private WebDriver driver;
    private LocatorUtil locatorUtil;
    private WaitUtil waitUtil;
    private Scrollpage scrollpage;

    public SearchFlights_PO(WebDriver driver) {
        this.driver=driver;
        this.locatorUtil = new LocatorUtil("src/main/java/MMT_Objects/Locators.properties");
        this.waitUtil= new WaitUtil(driver);
        this.scrollpage=new Scrollpage(driver);
    }

    public void Check_FlightMode(){

        By FlightMode=locatorUtil.getLocator("Flightmode");
        WebElement Flightmode= waitUtil.waitForElementWithFluentWait(FlightMode,10,1);
        Flightmode.click();
    }

    public void TypeofTrip(){
            //after fluentwaits
            By TypeofTripLocator =locatorUtil.getLocator("TypeofTrip"); //defining locator to choose type of trip
            WebElement roundTripElement = waitUtil.waitForElementWithFluentWait(TypeofTripLocator,10,1);
            roundTripElement.click();
    }

    public void chooseBoardingAndDestination(String fromcity,String tocity){
        Selectcity(locatorUtil.getLocator("FromCity"),fromcity);
        Selectcity(locatorUtil.getLocator("ToCity"),tocity);
    }

    public void Selectcity(By cityLocator,String cityname) {
        WebElement SelectCity = waitUtil.waitForElementWithFluentWait(cityLocator,10,1);
        SelectCity.click();
        By searchbar=locatorUtil.getLocator("SearchBar");
        WebElement SearchBar= waitUtil.waitForElementWithFluentWait(searchbar,10,1);
        SearchBar.sendKeys(cityname);
        //driver.findElement(locatorUtil.getLocator("SearchBar")).sendKeys(cityname);
        By Suggested_city=locatorUtil.getLocator("Suggested_city");
        WebElement suggest= waitUtil.waitForElementWithFluentWait(Suggested_city,10,1);
        suggest.click();
    }
    public void BookingDates(String FromDate,String ToDate) throws InterruptedException {
        SelectingDates(FromDate);
        SelectingDates(ToDate);
    }
    public void SelectingDates(String Date) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@aria-label,'" + Date + "')]")).click();

    }

public void Travelclass(String adults, String children, String infants,String travelclass) throws InterruptedException {
    // Open the travel class selection
    driver.findElement(locatorUtil.getLocator("TravelClassBtn")).click();

    // Call the SelectPassengers method to choose the number of passengers like adults,children,infants and selecting travelclass
    Thread.sleep(2000);
    SelectPassengers(adults, children, infants,travelclass);
    //To scroll the page
    scrollpage.Scrolltilloffset(locatorUtil.getLocator("TravelClassApply"),100);
    //make a fluent wait and click on element
    WebElement applybtn = waitUtil.waitForElementWithFluentWait(locatorUtil.getLocator("TravelClassApply"),5,1);
    Thread.sleep(3000);
    applybtn.click();
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
//        String dynamicXPath_Specialfare="//div[contains(@class, 'white-space-no-wrap blackText latoBold lineHeight18 darkGreyText appendBottom3') and contains(text(), '"+special_fare+"')]";
//        driver.findElement(By.xpath(dynamicXPath_Specialfare)).click();
        Radiobtn(special_fare);
    }
    public void Radiobtn(String special_fare){
        String dynamicXPath_Specialfare="//div[@class='white-space-no-wrap blackText latoBold lineHeight18 darkGreyText appendBottom3' and text()='"+special_fare+"']"; ////div[text()='Student']//../../div//input[@type='radio']
        By radiolocator=By.xpath(dynamicXPath_Specialfare);
        WebElement radiobtn = waitUtil.waitForElementWithFluentWait(radiolocator, 10, 1);
        radiobtn.click();
    }
    public void Searchbtn(){
        //driver.findElement(locatorUtil.getLocator("SearchBtn")).click();
        WebElement searchbtn=driver.findElement(locatorUtil.getLocator("SearchBtn"));
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchbtn);
        Actions actions=new Actions(driver);
        actions.moveToElement(searchbtn).click().perform();
        //System.out.println("Today's task completed");
    }
}
