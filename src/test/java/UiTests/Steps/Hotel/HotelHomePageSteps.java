package UiTests.Steps.Hotel;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.Given;

public class HotelHomePageSteps {

    private final TestContext context;

    public HotelHomePageSteps(TestContext context) {
        this.context = context;
    }

    // ******************** Given section ***********

    @Given("The user loaded the hotel main page")
    public void theUserLoadedTheHotelMainPage(){
        context.pm.getHotelHomePage().loadHomePage();
    }

    // ******************** When section ***********


    // ******************** Then section ***********

}
