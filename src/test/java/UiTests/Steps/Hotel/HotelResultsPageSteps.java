package UiTests.Steps.Hotel;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelResultsPageSteps {

    private final TestContext context;

    public HotelResultsPageSteps(TestContext context) {
        this.context = context;
    }

    // ******************** Given section ***********


    // ******************** When section ***********

    @When("The user selects book now the first hotel")
    public void theUserSelectsBookNowTheFirstHotel() {
        context.pm.getHotelResultsPage().clickOnTheFirstBookButton();
    }

    @When("The user confirms the hotel selection in shopping cart")
    public void theUserConfirmsHotelSelectionInShoppingCart() {
        context.pm.getHotelResultsPage().clickOnTheProceedToCheckoutButton();
    }


    // ******************** Then section ***********

    @Then("The user should see found hotel offers")
    public void theUserShouldSeeFoundHotelOffers(){
        context.pm.getHotelResultsPage().verifyHotelsSearch();
    }
}
