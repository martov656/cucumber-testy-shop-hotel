package UiTests.Steps.Hotel;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelAddAddressPageSteps {

    private final TestContext context;

    public HotelAddAddressPageSteps(TestContext context) {
        this.context = context;
    }

    // ******************** Given section ***********


    // ******************** When section ***********
    @When("The user fills in the new address details into the form")
    public void theUserFillsInTheNewAddressDetailsIntoTheForm() {
        context.pm.getHotelNewAddressesPage().fillAddress("Evropska", "", "16000", "Praha", "", "603603603", "Address");
    }

    @When("The user saves the new address form")
    public void theUserSavesTheNewAddressForm() {
        context.pm.getHotelNewAddressesPage().saveAddress();
    }


    // ******************** Then section ***********



}
