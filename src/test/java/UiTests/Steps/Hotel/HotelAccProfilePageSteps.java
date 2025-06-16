package UiTests.Steps.Hotel;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelAccProfilePageSteps {

    private final TestContext context;

    public HotelAccProfilePageSteps(TestContext context) {
        this.context = context;
    }

    // ******************** Given section ***********
    @Given("The user clicked on my addresses option in the profile")
    public void theUserClickedOnMyAddressesOptionInTheProfile(){
        context.pm.getHotelAccProfilePage().addMyFirstAddress();
    }

    @Given("The user went to main hotel page")
    public void theUserWentToMainHotelPage() {
        context.pm.getHotelAccProfilePage().goHomePage();
    }

    // ******************** When section ***********

    @When("The user fills in the registration form and press register")
    public void theUserFillsInTheRegistrationFormAndPressRegister() {
        context.pm.getHotelCreateAccountPage().createAccount();
    }


    @When("The user fills in first name {string} and surname {string} with password {string}")
    public void theUserFillsInFirstNameRegexAndSurnameRegexWithPasswordRegex(String firsName, String surname, String passwd) {
        context.pm.getHotelCreateAccountPage().createAccount(firsName, surname, passwd);
    }


    // ******************** Then section ***********

    @Then("The user should see the account created")
    public void theUserShouldSeeTheAccountCreated() {
        context.pm.getHotelAccProfilePage().validateAccountCraated();
    }
}
