package UiTests.Steps.Hotel;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HotelAuthPageSteps {

    private final TestContext context;

    public HotelAuthPageSteps(TestContext context) {
        this.context = context;
    }

    // ******************** Given section ***********

    @Given("The user entered his email and password")
    public void theUserEnteredHisEmailAndPassword() {
        context.pm.getHotelAuthenticationPage().login();
    }

    // ******************** When section ***********

    @When("The user fills in email and selects Create an account")
    public void theUserFillsInEmailAndSelectsCreateAnAccount() {
        context.pm.getHotelAuthenticationPage().createEmailAndClickButton();
    }


    // ******************** Then section ***********

}
