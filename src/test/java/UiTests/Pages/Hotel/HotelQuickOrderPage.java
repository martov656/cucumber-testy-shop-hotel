package UiTests.Pages.Hotel;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotelQuickOrderPage extends BasePage {
    public HotelQuickOrderPage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    @FindBy(className = "shopping_cart")
    WebElement shoppingCart;

    @FindBy(id = "cgv")
    WebElement termsAndConditionsBox;

    @FindBy(xpath="//a[@title='Pay by bank wire']")
    WebElement bankWire;

    @FindBy(xpath="//button/span[contains(.,'I confirm my order')]")
    WebElement confirmButton;

    public void clickShoppingCart() {
        this.clickWebElement(this.shoppingCart);
    }

    public void clickTermsAndConditions() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cgv"))).click();
    }

    public void clickPaymentByBank() {
        this.clickWebElement(this.bankWire);
    }

    public void clickConfirmOrderButton() {
        this.clickWebElement(this.confirmButton);
    }

}



