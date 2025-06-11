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

    // *********************** Elements *************************************

    @FindBy(id = "customer_firstname")
    WebElement firstnameInput;

    @FindBy(id = "customer_lastname")
    WebElement lastnameInput;

    @FindBy(id = "passwd")
    WebElement passwdInput;

    @FindBy(id = "submitAccount")
    WebElement accountButton;

    // *********************** Methods *************************************

    public void createAccount() {
        this.sendKeysToWebElement(firstnameInput, "Jan");
        this.sendKeysToWebElement(lastnameInput, "Novak");
        this.sendKeysToWebElement(passwdInput, "Heslo12345");
        this.clickWebElement(accountButton);
    }

    public void createAccount(String firstName, String surname, String passwd) {
        this.sendKeysToWebElement(firstnameInput, firstName);
        this.sendKeysToWebElement(lastnameInput, surname);
        this.sendKeysToWebElement(passwdInput, passwd);
        this.clickWebElement(accountButton);
    }


}
