package UiTests.Pages.Hotel;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelCreateAccountPage extends BasePage {
    public HotelCreateAccountPage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    @FindBy(id = "customer_firstname")
    WebElement firstnameInput;

    @FindBy(id = "customer_lastname")
    WebElement lastnameInput;

    @FindBy(id = "passwd")
    WebElement passwdInput;

    @FindBy(id = "submitAccount")
    WebElement accountButton;

    public void createAccount() {
        this.sendKeysToWebElement(firstnameInput, "Jan");
        this.sendKeysToWebElement(lastnameInput, "Novak");
        this.sendKeysToWebElement(passwdInput, "Heslo12345");
        this.clickWebElement(accountButton);


    }


}
