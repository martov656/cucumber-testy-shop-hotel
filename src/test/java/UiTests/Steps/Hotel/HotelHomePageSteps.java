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

    // ******************** When section ***********

    @When("The user clicks Sign in button")
    public void theUserClicksSignInButton(){
        context.pm.getHotelHomePage().clickSignIn();
    }


    // ******************** Then section ***********

}
