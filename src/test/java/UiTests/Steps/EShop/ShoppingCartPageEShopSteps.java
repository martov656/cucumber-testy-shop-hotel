package UiTests.Steps.EShop;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.When;

public class ShoppingCartPageEShopSteps {

    private final TestContext context;

    public ShoppingCartPageEShopSteps(TestContext context) {
        this.context = context;

    }

    @When("^The user press checkout in eshop$")
    public void theUserPressCheckoutInEshop() {
        context.pm.getEShopShoppingCartPage().pressCheckout();
    }

}
