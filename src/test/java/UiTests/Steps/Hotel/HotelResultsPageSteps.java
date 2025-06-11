package UiTests.Steps.Hotel;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.Then;

public class HotelResultsPageSteps {

    private final TestContext context;

    public HotelResultsPageSteps(TestContext context) {
        this.context = context;
    }

    // ******************** Given section ***********


    // ******************** When section ***********


    // ******************** Then section ***********

    @Then("The user should see found hotel offers")
    public void theUserShouldSeeFoundHotelOffers(){
        context.pm.getHotelResultsPage().verifyHotelsSearch();
    }
}
