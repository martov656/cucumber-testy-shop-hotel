package UiTests.Steps.EShop;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MainPageEShopSteps {

    private final TestContext context;

    public MainPageEShopSteps(TestContext context) {
        this.context = context;

    }

    @Given("^The user loaded the eshop main page$")
    public void theUserLoadedTheEShopManiPage() {
        context.pm.getEShopHomePage().loadHomePage();
    }

    @Given("^The user pressed username in the main page of the eshop$")
    public void theUserPressedUsernameInTheEShopManiPage() {
        context.pm.getEShopHomePage().pressUserNameInLogin();
    }

    @Given("^The user Signed in to eshop$")
    public void theUserSignInToEShopMainPage() {
        context.pm.getEShopHomePage().signInToEShop(context.email);
    }

    @Given("^The existing user Signed in to eshop$")
    public void theExistingUserSignInToEShopMainPage() {
        context.pm.getEShopHomePage().signInToEShop();
    }

    @Given("^The user went to main page in eshop$")
    public void theUserWentToMainPage() {
        context.pm.getEShopHomePage().goToMainPage();
    }


    @When("^The user clicks Sign in button in eshop$")
    public void theUserClicksSignInButton() {
        context.pm.getEShopHomePage().clickSignIn();
    }

    @When("^The user selects Create an account in eshop$")
    public void theUserFillsInEmailAndSelectsCreateAnAccount() {
        context.pm.getEShopLoginPage().clickCreateAccount();
    }


    @When("^The user selects Create an account with first name \"<firstName>\" and surname \"<surname>\" in eshop$")
    public void theUserSelectsCreateAnAccountWithFirstNameAndSurname() {
        context.pm.getEShopLoginPage().clickCreateAccount();
    }

    @When("^The user selects a Hummingbird Printed Sweater for purchase in eshop$")
    public void theUserSelectsHummingbirdPrintedSweaterForPurchase() {
        context.pm.getEShopHomePage().selectProduct();
    }


    @Then("^The user should see the account logged in on eshop home page$")
    public void theUserShouldSeeTheAccountLoggedInOnEshopHomePage() {
        context.pm.getEShopHomePage().validateLoggedInUserSection();
    }

}
