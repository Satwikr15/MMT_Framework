package MMT_Testcases.SearchFlightTestCases;

import MMT_Objects.BaseClass.Base_Class;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchFlights_SD extends Base_Class {

    @Given("User in HomePage of MakeMyTrip")
    public void User_in_HomePage_of_MakeMyTrip() {
        browsersetup();
    }

    @When("User Selects flight mode")
    public void user_selects_flight_mode() {
        sfo.Check_FlightMode();
    }

    @And("User Chooses Type of Trip")
    public void user_chooses_type_of_trip() {
        sfo.TypeofTrip();
    }

    @And("User Selects Boarding at {string} to {string}")
    public void user_selects_boarding_at_to(String fromcity, String tocity) throws InterruptedException {
        sfo.chooseBoardingAndDestination(fromcity,tocity);
    }

    @And("User Selects the Booking dates from {string} and {string}")
    public void user_selects_the_booking_dates_from_and(String FromDate, String ToDate) throws InterruptedException {
        sfo.BookingDates(FromDate,ToDate);
    }

    @And("User Chooses the travel class with {string} Adults, {string} Children, and {string} Infants and {string} Class")
    public void user_chooses_the_travel_class_with_adults_children_and_infants_and_class(String adults, String children, String infants, String travelclass) throws InterruptedException{
        sfo.Travelclass(adults, children, infants,travelclass);
    }

    @And("User applies {string} Special Fare")
    public void user_applies_special_fare(String Special_fare) {
        sfo.Specialfare(Special_fare);
    }

    @Then("User Clicks on search btn for flights")
    public void user_clicks_on_search_btn_for_flights() {
        sfo.Searchbtn();
    }

}
