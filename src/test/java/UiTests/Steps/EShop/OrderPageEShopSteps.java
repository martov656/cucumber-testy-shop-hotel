package UiTests.Steps.EShop;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.When;

import java.io.IOException;

public class OrderPageEShopSteps {

    private final TestContext context;

    public OrderPageEShopSteps(TestContext context) {
        this.context = context;

    }

    @When("^The user confirms the address in eshop$")
    public void theUserConfirmsTheAddressInEshop() {
        context.pm.getEShopOrderPage().pressContinueAddress();
    }

    @When("^The user selects the delivery method - PrestaShop `pick up in store` in eshop$")
    public void theUserSelectsTheDeliveryMethodPickupInStoreInEshop() {
        context.pm.getEShopOrderPage().pressContinueDelivery();
    }

    @When("^The user selects the Pay by Check payment option in eshop$")
    public void theUserSelectsThePayByCHeckPaymentOptionInEshop() {
        context.pm.getEShopOrderPage().payByCheckOption();
    }

    @When("^The user takes a screenshot of the order confirmation and the amount in the order in eshop$")
    public void theUserTakesScreenshotOfTheOrderInEshop() throws IOException {
        context.pm.getEShopOrderPage().takeScreenshotOfTheOrder();
    }

    @When("^The user goes to the order history in eshop$")
    public void theUserGoesToOrderHistoryInEshop() throws IOException {
        context.pm.getEShopHomePage().pressUserNameInLogin();
        context.pm.getEShopMyAccountPage().pressOrderHistory();
    }
}
