package UiTests.Steps.Hotel;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.When;


public class HotelQuickOrderPageSteps {
    private final TestContext context;

    public HotelQuickOrderPageSteps(TestContext context) {
        this.context = context;
    }


    @When("The user opens the shopping cart")
    public void theUserOpensTheShoppingCart() {
        context.pm.getHotelQuickOrderPage().clickShoppingCart();
    }

    @When("The user confirms the business terms and conditions")
    public void theUserConfirmsTermsAndConditions() {
        context.pm.getHotelQuickOrderPage().clickTermsAndConditions();
    }

    @When("The user clicks payment by bank account")
    public void theUserClicksPaymentByBankWire() {
        context.pm.getHotelQuickOrderPage().clickPaymentByBank();
    }

    @When("The user confirms the order")
    public void theUserConfirmsTheOrder() {
        context.pm.getHotelQuickOrderPage().clickConfirmOrderButton();
    }

}
