package UiTests.Steps.EShop;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.When;

public class LoginPageEShopSteps {

    private final TestContext context;
    public LoginPageEShopSteps(TestContext context) {
        this.context = context;
    }

    @When("^The user fills in the registration form in eshop$")
    public void theUserFillsInEmailAndSelectsCreteAnAccount(){
        context.pm.getEShopLoginPage().createNewConsumerDetails("Johny", "Test");
    }


    @When("^The user fills in the registration form with first name \"(.*)\" and surname \"(.*)\" in eshop$")
    public void theUserFillsInRegistrationWithFirstNameAndSurnameAndSelectsCreteAnAccount(String firstName, String surname){
        context.pm.getEShopLoginPage().createNewConsumerDetails(firstName, surname);
    }

    @When("^The user press save in eshop$")
    public void theUserPressSaveInEshop(){
        context.pm.getEShopLoginPage().pressSave();
    }


}
