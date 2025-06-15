package UiTests.Steps.EShop;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.Then;

public class OrderHistoryEShopSteps {

    private final TestContext context;
    public OrderHistoryEShopSteps(TestContext context) {
        this.context = context;
    }

    @Then("^The user should see order in the list history in eshop$")
    public void theUserShouldSeeOrderInListHistory(){
        context.pm.getEShopOrderHistoryPage().validateOrderInOrderHistory();
    }


    @Then("^The user should see the status `Awaiting check payment` in eshop$")
    public void theUserShouldSeeStatusInListHistory(){
        context.pm.getEShopOrderHistoryPage().validateStatusInOrderHistory();
    }

    @Then("^The user should see the amount of the order matches with purchase in eshop$")
    public void theUserShouldSeeAmountInListHistory(){
        context.pm.getEShopOrderHistoryPage().validateAmountInOrderHistory();
    }

}
