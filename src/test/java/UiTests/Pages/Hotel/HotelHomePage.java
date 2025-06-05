package UiTests.Pages.Hotel;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.openqa.selenium.support.PageFactory;

public class HotelHomePage extends BasePage {
    public HotelHomePage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }


    public void loadHomePage() {
        driver.manage().window().maximize();
        driver.get(context.configProperties.getProperty("hotelUrl"));
    }
}
