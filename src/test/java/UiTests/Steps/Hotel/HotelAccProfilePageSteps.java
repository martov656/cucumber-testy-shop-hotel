package UiTests.Steps.Hotel;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelAccProfilePageSteps {

    private final TestContext context;

    public HotelAccProfilePageSteps(TestContext context) {
        this.context = context;
    }

    // ******************** Given section ***********


    // ******************** When section ***********


    // ******************** Then section ***********

    @Then("The user should see the account created")
    public void theUserShouldSeeTheAccountCreated() {
        context.pm.getHotelAccProfilePage().validateAccountCraated();
    }
}
