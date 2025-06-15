package UiTests.Steps.EShop;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccountPageEShopSteps {

    private final TestContext context;

    public MyAccountPageEShopSteps(TestContext context) {
        this.context = context;

    }

    @Given("^The existing user had just one address in the profile in eshop$")
    public void theExistingUserHadJustOneAddressInTheProfileInEshop() {
        context.pm.getEShopMyAccountPage().deleteAllAddressesButFirstOne();
    }

    @Given("^The user clicked on addresses option in the profile in eshop$")
    public void theUserClickedOnAddressOptionInTheProfileInEshop() {
        context.pm.getEShopMyAccountPage().pressAddressButton();
    }

    @When("^The user clicked on add first addresses option in the profile in eshop$")
    public void theUserClickedOnAddFirstAddressOptionInTheProfileInEshop() {
        context.pm.getEShopMyAccountPage().pressFirstAddressButton();
    }


    @When("^The user clicks on addresses option in the profile in eshop$")
    public void theUserClicksOnAddressOptionInTheProfileInEshop() {
        context.pm.getEShopMyAccountPage().pressAddressButton();
    }


    @When("^The user clicks on create next addresses link in the profile in eshop$")
    public void theUserClicksOnAddNextAddressLinkInTheProfileInEshop() {
        context.pm.getEShopMyAccountPage().pressCreateAddressLink();
    }

    @When("^The user fills in the new address details into the form in eshop$")
    public void theUserFillsInTheNewAddressDetailsInTheProfileInEshop() {
        context.pm.getEShopMyAccountPage().fillsDetailsIntoNewAddress();
    }

    @When("^The user press save the new address form in eshop$")
    public void theUserSaveTheNewAddressFormInTheProfileInEshop() {
        context.pm.getEShopMyAccountPage().saveNewAddress();
    }

    @When("^The user sees confirmation message address added in eshop$")
    public void theUserSeesConfirmationAddressAddedToTheListInEshop() {
        context.pm.getEShopMyAccountPage().validateAddressConfirmation();
    }

    @When("^The user deletes the second address from the profile in eshop$")
    public void theUserDeletesTheSecondAddressFromTheListInEshop() {
        context.pm.getEShopMyAccountPage().pressDeleteAddress(1);
    }

    @Then("^The user should see new address added to the list in eshop$")
    public void theUserShouldSeeNewAddressAddedToTheListInEshop() {
        context.pm.getEShopMyAccountPage().validateAddedFirstAddress();
    }

    @Then("^The user should see one address added to the list in eshop$")
    public void theUserShouldSeeOneAddressAddedToTheListInEshop() {
        context.pm.getEShopMyAccountPage().validateAddedFirstAddress();
        ;
    }

    @Then("^The user should see confirmation message address added in eshop$")
    public void theUserShouldSeeConfirmationAddressAddedToTheListInEshop() {
        context.pm.getEShopMyAccountPage().validateAddressConfirmation();
    }

    @Then("^The user should validate first address details entry in eshop$")
    public void theUserShouldValidateFirstAddressDetailsEntryInEshop() {
        context.pm.getEShopMyAccountPage().validateAddedFirstAddress();
    }

    @Then("^The user should see the confirmation message deleting the address in the profile in eshop$")
    public void theUserShouldSeeDeletionConfirmationAddressInEshop() {
        context.pm.getEShopMyAccountPage().validateAddressDeleted();
    }


}
