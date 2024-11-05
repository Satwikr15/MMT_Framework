package MMT_Testcases.SearchFlightTestCases;

import MMT_Testcases.Run;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SearchFlightsTestCases extends Base_Class{

    @BeforeTest
    public void setup(){
        browsersetup();
    }

    @Test
    public void flightsesarching() throws InterruptedException {
        sfo.Check_FlightMode();
        sfo.TypeofTrip();
        sfo.FromCity();
        sfo.ToCity();
        sfo.BookingDates();
        sfo.Travelclass();
        sfo.Specialfare();
        sfo.Searchbtn();
    }

}
