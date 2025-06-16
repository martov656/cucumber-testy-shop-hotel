package UiTests.Steps.Hotel;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.Then;


public class HotelOrderConfirmationPageSteps {
    private final TestContext context;

    public HotelOrderConfirmationPageSteps(TestContext context) {
        this.context = context;
    }


    @Then("The user should see the order confirmation title and alert displayed")
    public void theUserShouldSeeOrderConfirmation() {
        context.pm.getHotelOrderConfirmationPage().validateOrderConfirmation();
    }

}
