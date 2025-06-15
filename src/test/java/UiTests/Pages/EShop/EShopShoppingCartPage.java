package UiTests.Pages.EShop;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class EShopShoppingCartPage extends BasePage {

    public EShopShoppingCartPage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    @FindBy(xpath = "//a[contains(.,'Proceed to checkout')]")
    WebElement checkoutButton;



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

}
