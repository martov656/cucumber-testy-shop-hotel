package UiTests.Pages.EShop;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class EShopProductPage extends BasePage {

    public EShopProductPage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    @FindBy(xpath = "//span[contains(.,'Save 20%')]")
    WebElement discount20Percent;

    @FindBy(xpath = "//select[@id='group_1' and @aria-label='Size']")
    WebElement sizeSelect;

    @FindBy(xpath = "//button[@data-button-action='add-to-cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//button[contains(@class, 'bootstrap-touchspin-up')]")
    WebElement qtyUp;


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

    public void enterQtyOfProduct(String qty)  {
        wait.until(ExpectedConditions.elementToBeClickable(qtyUp));
        for (int i = 0; i < Integer.parseInt(qty); i++) {
            qtyUp.click();
            threadSleep(500);
        }
    }

    public void addToCart() {
        clickWebElement(addToCartButton);
    }

}
