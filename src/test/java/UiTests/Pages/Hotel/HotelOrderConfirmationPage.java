package UiTests.Pages.Hotel;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelOrderConfirmationPage extends BasePage {
    public HotelOrderConfirmationPage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    @FindBy(xpath = "//h1[text() = 'Order confirmation']")
    WebElement orderConfirmation;

    @FindBy(className = "alert-success")
    WebElement yourOrderIsComplete;

    public void validateOrderConfirmation() {
        Assertions.assertTrue(this.orderConfirmation.isDisplayed(), "Order confirmation is not displayed");
        Assertions.assertEquals("Your order on MyBooking is complete.", this.yourOrderIsComplete.getText(),"Order confirmation alert failed");
    }

}



