package UiTests.Pages.EShop;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EShopLoginPage extends BasePage {

    public EShopLoginPage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    @FindBy(id = "SubmitCreate")
    WebElement createButton;

    @FindBy(id = "email_create")
    WebElement emailInput;

    @FindBy(id = "email")
    WebElement emailLoginInput;

    @FindBy(id = "passwd")
    WebElement passwordLoginInput;

    @FindBy(id = "SubmitLogin")
    WebElement submitLoginButton;

    @FindBy(xpath = "//div[@class='no-account']/a[contains(.,'No account? Create one here')]")
    WebElement createAccountOption;

    @FindBy(id = "field-id_gender-1")
    WebElement titleInput;

    @FindBy(id = "field-firstname")
    WebElement firstNameInput;

    @FindBy(id = "field-lastname")
    WebElement lastNameInput;

    @FindBy(id = "field-email")
    WebElement randomEmailInput;

    @FindBy(id = "field-password")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@name='customer_privacy']")
    WebElement dataPrivacyCheckbox;

    @FindBy(xpath = "//input[@name='psgdpr']")
    WebElement dataTermConditionsCheckbox;

    @FindBy(xpath = "//button[contains(.,'Save')]")
    WebElement saveButton;


    public void inputEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailInput));
        sendKeysToWebElement(emailInput, email);
    }

    public void loginIntoSystem() {
        sendKeysToWebElement(emailLoginInput, context.email);
        sendKeysToWebElement(passwordLoginInput, "1234567");
        clickWebElement(submitLoginButton);
    }

    public void clickCreateAccount() {
        clickWebElement(createAccountOption);
    }

    public void createNewConsumerDetails(String firstName, String surname) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(titleInput.getDomProperty("id"))));
        Actions actions = new Actions(driver);
        actions.moveToElement(titleInput).click().build().perform();
        //clickWebElement(titleInput);
        sendKeysToWebElement(firstNameInput, firstName);
        sendKeysToWebElement(lastNameInput, surname);
        context.email = "test" + getRandomNumber() + "@eshop.com";
        sendKeysToWebElement(randomEmailInput, context.email);
        sendKeysToWebElement(passwordInput, "Pass123");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='customer_privacy']")));
        dataPrivacyCheckbox.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='psgdpr']")));
        dataTermConditionsCheckbox.click();
    }

    public void pressSave() {
        clickWebElement(saveButton);
    }
}
