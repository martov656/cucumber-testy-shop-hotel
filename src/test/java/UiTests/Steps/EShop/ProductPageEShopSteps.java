package UiTests.Steps.EShop;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.When;

public class ProductPageEShopSteps {

    private final TestContext context;

    public ProductPageEShopSteps(TestContext context) {
        this.context = context;

    }

    @When("^The user verifies the discount is 20% in eshop$")
    public void theUserVerifiesTheDiscount20PercentInEshop() {
        context.pm.getEShopProductPage().verifyTheDiscount20Percent();
    }

    @When("^The user chooses \"(.*)\" size in eshop$")
    public void theUserChoosesSizeInEshop(String size) {
        context.pm.getEShopProductPage().chooseSize(size);
    }

    @When("^The user enters \"(.*)\" pieces in thee shop$")
    public void theUserEntersPiecesInEshop(String qty) throws InterruptedException {
        context.pm.getEShopProductPage().enterQtyOfProduct(qty);
    }

    @When("^The user adds the product to the cart in eshop$")
    public void theUserAddsTheProductToCartInEshop() {
        context.pm.getEShopProductPage().addToCart();
    }

}
