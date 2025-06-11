package UiTests.Pages.Hotel;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotelAccProfilePage extends BasePage {
    public HotelAccProfilePage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    // *********************** Elements *************************************

    @FindBy(xpath = "//p[contains(.,'Your account has been created.')]")
    WebElement validateLabel;

    @FindBy(xpath = "//span[contains(.,'Add my first address')]")
    WebElement addLinkMyAddress;


    // *********************** Methods *************************************

    public void validateAccountCraated() {
        try {
            wait.until(ExpectedConditions.visibilityOf(this.validateLabel));
        } catch (Exception e) {
            Assertions.fail("Account has not been created.");
        }
    }

    public void addMyFirstAddress() {
        this.clickWebElement(addLinkMyAddress);
    }


}
