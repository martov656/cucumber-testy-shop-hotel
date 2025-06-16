package UiTests.Pages.EShop;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class EShopHomePage extends BasePage {

    public EShopHomePage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    @FindBy(xpath = "//span[text()='Sign in']")
    WebElement signInLink;

    @FindBy(xpath = "//div[@class='user-info']")
    WebElement loggedInUserSection;

    @FindBy(xpath = "//div[@class='user-info']/a[@class='account']")
    WebElement userNameLink;

    @FindBy(id = "field-email")
    WebElement emailInput;

    @FindBy(id = "field-password")
    WebElement passwordInput;

    @FindBy(id = "submit-login")
    WebElement loginButton;

    @FindBy(xpath = "//h3/a[contains(.,'Hummingbird printed sweater')]")
    WebElement hummingbirdPrintedSweaterProduct;

    @FindBy(id = "_desktop_logo")
    WebElement myStoreLogo;

    @FindBy(xpath = "//span[contains(.,'Save 20%')]")
    WebElement discount20Percent;

    @FindBy(xpath = "//select[@id='group_1' and @aria-label='Size']")
    WebElement sizeSelect;

    @FindBy(xpath = "//button[@data-button-action='add-to-cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[contains(.,'Proceed to checkout')]")
    WebElement checkoutButton;

    @FindBy(id = "quantity_wanted")
    WebElement qtyInput;

    @FindBy(xpath = "//button[contains(@class, 'bootstrap-touchspin-up')]")
    WebElement qtyUp;

    @FindBy(xpath = "//button[@name='confirm-addresses' and contains(text(),'Continue')]")
    WebElement continueAddressButton;

    @FindBy(xpath = "//button[@name='confirmDeliveryOption' and contains(text(),'Continue')]")
    WebElement continueDeliveryButton;

    @FindBy(id = "payment-option-1")
    WebElement payByCheckRadioButton;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement termAndConditionsCheckbox;

    @FindBy(xpath = "//button[contains(.,'Place order')]")
    WebElement placeOrderButton;

    @FindBy(xpath = "//h3[contains(.,'Your order is confirmed')]")
    WebElement orderConfirmationTitle;

    @FindBy(xpath = "//li[contains(.,'Payment amount.')]/span[@class='price']/strong")
    WebElement orderAmount;

    @FindBy(id = "order-reference-value")
    WebElement orderReference;


    public void loadHomePage() {
        driver.manage().window().maximize();
        driver.get(context.configProperties.getProperty("eShopUrl"));
    }

    public void clickSignIn() {
        clickWebElement(signInLink);
    }

    public void signInToEShop() {
        driver.navigate().refresh();
        clickSignIn();
        sendKeysToWebElement(emailInput, context.configProperties.getProperty("eShopUserEmail"));
        sendKeysToWebElement(passwordInput, context.configProperties.getProperty("eShopUserPassword"));
        clickWebElement(loginButton);
    }

    public void signInToEShop(String email) {
        driver.navigate().refresh();
        clickSignIn();
        sendKeysToWebElement(emailInput, email);
        sendKeysToWebElement(passwordInput, "Pass123");
        clickWebElement(loginButton);
    }


    public void goToMainPage() {
        clickWebElement(myStoreLogo);
    }

    public void pressUserNameInLogin() {
        clickWebElement(userNameLink);
    }

    public void validateLoggedInUserSection() {
        try{
            wait.until(ExpectedConditions.visibilityOf(loggedInUserSection));
        }catch(Exception e){
            this.driver.navigate().refresh(); // due to stale element exception potentially
            wait.until(ExpectedConditions.visibilityOf(loggedInUserSection));
        }
        Assertions.assertTrue(loggedInUserSection.isDisplayed(),"Logged in user section not visible ...");
    }

    public void selectProduct() {
        //wait.until(ExpectedConditions.visibilityOf(hummingbirdPrintedSweaterProduct));
        clickWebElement(hummingbirdPrintedSweaterProduct);
    }

    public void verifyTheDiscount20Percent() {
        wait.until(ExpectedConditions.visibilityOf(discount20Percent));
        Assertions.assertTrue(discount20Percent.isDisplayed(),"Discount 20% not present ...");
    }

    public void chooseSize(String size) {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='group_1' and @aria-label='Size']")));
        //wait.until(ExpectedConditions.visibilityOf(sizeSelect));
        clickWebElement(sizeSelect);
        Select selector = new Select(sizeSelect);
        selector.selectByVisibleText(size);
    }

    public void enterQtyOfProduct(String qty) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(qtyUp));
        for (int i = 0; i < Integer.parseInt(qty); i++) {
            qtyUp.click();
            threadSleep(500);
        }
    }


    public void addToCart() {
        clickWebElement(addToCartButton);
    }

    public void pressCheckout() {
        try {
            clickWebElement(checkoutButton);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            wait.withTimeout(Duration.ofSeconds(5)).until(ExpectedConditions.urlContains("controller=order"));
        } catch (WebDriverException e){
            clickWebElement(checkoutButton);
            wait.until(ExpectedConditions.urlContains("controller=order"));
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public void pressContinueAddress() {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='confirm-addresses' and contains(text(),'Continue')]")));
        clickWebElement(continueAddressButton);
    }

    public void pressContinueDelivery() {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='confirmDeliveryOption' and contains(text(),'Continue')]")));
        clickWebElement(continueDeliveryButton);
    }

    public void payByCheckOption() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("payment-option-1")));
        payByCheckRadioButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("conditions_to_approve[terms-and-conditions]")));
        termAndConditionsCheckbox.click();
        clickWebElement(placeOrderButton);
    }

    public void takeScreenshotOfTheOrder() {
        wait.until(ExpectedConditions.visibilityOf(orderConfirmationTitle));
        context.orderReference = orderReference.getText().substring(16);
        context.orderTotal = orderAmount.getText();
        takeScreenshot();
    }
}
