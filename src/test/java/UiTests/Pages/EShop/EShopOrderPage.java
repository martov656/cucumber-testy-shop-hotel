package UiTests.Pages.EShop;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EShopOrderPage extends BasePage {

    public EShopOrderPage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }


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
