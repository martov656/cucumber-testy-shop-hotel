package UiTests.Steps.Hotel;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.When;

public class HotelAccountPageSteps {

    private final TestContext context;

    public HotelAccountPageSteps(TestContext context) {
        this.context = context;
    }

    // ******************** Given section ***********


    // ******************** When section ***********

    @When("The user fills in the registration form and press register")
                                        public void theUserFillsInTheRegistrationFormAndPressRegister(){
        context.pm.getHotelCreateAccountPage().createAccount();
    }

    // ******************** Then section ***********

}
