package UiTests.Pages.EShop;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class EShopOrderHistoryPage extends BasePage {


    public EShopOrderHistoryPage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    @FindBy(xpath = "//*[@id='content']/table[contains(@class,'table')]/tbody/tr")
    List<WebElement> orderTable;


    public void validateOrderInOrderHistory() {
        wait.until(ExpectedConditions.visibilityOf(orderTable.get(0)));
        WebElement firsRow = orderTable.get(0);
        Assertions.assertEquals(context.orderReference.replaceAll("\\s", ""),firsRow.findElement(By.tagName("th")).getText().replaceAll("\\s", ""),"Order reference does not exist ...");
        context.orderHistoryStatus = firsRow.findElements(By.xpath("//td/span")).get(0).getText();
        context.orderHistoryPrice = firsRow.findElements(By.tagName("td")).get(1).getText();
    }

    public void validateStatusInOrderHistory() {
        Assertions.assertEquals( "Awaiting check payment", context.orderHistoryStatus , "Order status does not match ...");
    }

    public void validateAmountInOrderHistory() {
        Assertions.assertEquals( "€143.60", context.orderHistoryPrice, "Order amount does not match ...");
    }
}
