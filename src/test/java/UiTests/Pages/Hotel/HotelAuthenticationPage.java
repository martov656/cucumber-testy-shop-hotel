package UiTests.Pages.Hotel;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotelAuthenticationPage extends BasePage {
    public HotelAuthenticationPage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    // *********************** Elements *************************************

    @FindBy(id = "email_create")
    WebElement emailInputCreate;

    @FindBy(id = "SubmitCreate")
    WebElement submitButtonCreate;

    @FindBy(id = "email")
    WebElement emailInputLogin;

    @FindBy(id = "passwd")
    WebElement passwordInputLogin;

    @FindBy(id = "SubmitLogin")
    WebElement submitLoginButton;


    // *********************** Methods *************************************

    public void createEmailAndClickButton() {
        context.email = "test" + this.getRandomNumber() + "@test.com";
        this.sendKeysToWebElement(emailInputCreate, context.email);
        this.clickWebElement(submitButtonCreate);


    }

    public void userLogin() {
       this.sendKeysToWebElement(emailInputLogin, context.email);
       this.sendKeysToWebElement(passwordInputLogin,"Heslo12345");
       this.clickWebElement(submitLoginButton);
    }

    public void login() {
        this.sendKeysToWebElement(emailInputLogin, context.configProperties.getProperty("hotelEmailUser"));
        this.sendKeysToWebElement(passwordInputLogin, context.configProperties.getProperty("hotelPasswdUser"));
        this.clickWebElement(submitLoginButton);
    }
}
