package UiTests.Pages.Hotel;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelAuthenticationPage extends BasePage {
    public HotelAuthenticationPage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    @FindBy(id = "email_create")
    WebElement emailInputCreate;

    @FindBy(id = "SubmitCreate")
    WebElement submitButtonCreate;

    public void createEmailAndClickButton() {
        this.sendKeysToWebElement(emailInputCreate, "test" + this.getRandomNumber() + "@test.com");
        this.clickWebElement(submitButtonCreate);


    }


}
