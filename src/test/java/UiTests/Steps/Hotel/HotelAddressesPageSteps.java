package UiTests.Steps.Hotel;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelAddressesPageSteps {

    private final TestContext context;

    public HotelAddressesPageSteps(TestContext context) {
        this.context = context;
    }

    // ******************** Given section ***********


    // ******************** When section ***********

    @When("The user fills in the new address details into the form")
    public void theUserFillsInNewAddressDetailsIntoForm(){
        context.pm.getHotelAddressesPage().fillInAddressForm();
    }

    // ******************** Then section ***********

    @Then("The user should see new address added to the list")
    public void theUserShouldSeeNewAddressAddedToTheList() {
        context.pm.getHotelAddressesPage().validateAddressCreated();
    }

}
