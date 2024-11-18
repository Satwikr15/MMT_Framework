Feature: Flight Search on MakeMyTrip

  Scenario: User Searches for Flights
    Given User in HomePage of MakeMyTrip
    When User Selects flight mode
    And User Chooses Type of Trip
    And User Selects Boarding at "Mumbai" to "Pune"
    And User Selects the Booking dates from "Nov 15 2024" and "Dec 12 2024"
    And User Chooses the travel class with "2" Adults, "0" Children, and "0" Infants and "First Class" Class
    And User applies "Senior Citizen" Special Fare
    Then User Clicks on search btn for flights