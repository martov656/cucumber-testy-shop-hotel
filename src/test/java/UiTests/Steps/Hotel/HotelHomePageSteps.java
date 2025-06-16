package UiTests.Steps.Hotel;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HotelHomePageSteps {

    private final TestContext context;

    public HotelHomePageSteps(TestContext context) {
        this.context = context;
    }

    // ******************** Given section ***********

    @Given("The user loaded the hotel main page")
    public void theUserLoadedTheHotelMainPage(){
        context.pm.getHotelHomePage().loadHomePage();
    }

    @Given("The user clicked Sign in button")
    public void theUserClickedSignInButton(){
        context.pm.getHotelHomePage().clickSignIn();
    }

    // ******************** When section ***********

    @When("The user clicks Sign in button")
    public void theUserClicksSignInButton(){
        context.pm.getHotelHomePage().clickSignIn();
    }

    @When("The user logged out the hotel system")
    public void theUserLoggedOutTheHotelSystem(){
        context.pm.getHotelHomePage().logoutUser();
    }

    @When("The user logged in the hotel system")
    public void theUserLoggedInTheHotelSystem(){
        context.pm.getHotelHomePage().clickSignIn();
        context.pm.getHotelAuthenticationPage().userLogin();
    }

    @When("The user enters hotel location {string} and hotel name {string}")
    public void theUserEntersHotelLocationRegexAndHotelNameRegex(String hotelLocation, String hotelName){
        context.pm.getHotelHomePage().enterHotelLocationAndName(hotelLocation, hotelName);
    }

    @When("The user enters checkIn and checkOut dates")
    public void theUserEntersCheckinAndCheckoutDates(){
        context.pm.getHotelHomePage().hotelCheckinCheckout();
    }

    @When ("The user clicks search for hotel")
    public void theUserClicksSearchForHotel(){
        context.pm.getHotelHomePage().searchHotelClick();
    }


    // ******************** Then section ***********

}
