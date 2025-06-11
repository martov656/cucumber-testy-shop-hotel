package UiTests.Pages.Hotel;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HotelAddressesPage extends BasePage {
    public HotelAddressesPage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    // *********************** Elements *************************************

    //WebElement validateAddressNameLabel = driver.findElement(By.xpath("//h3[contains(., '" + context.aliasName + "')]"));

    @FindBy(xpath = "//div[@class='col-xs-12 col-sm-12 address']")
    List <WebElement> addressList;


    // *********************** Methods *************************************

    public void validateAddressCraated() {
        try {
            wait.until(ExpectedConditions.visibilityOf(this.addressList.get(addressList.size()-1)));
        } catch (Exception e) {
            Assertions.fail("Address has not been created.");
        }
        Assertions.assertEquals(1, addressList.size(), "Address count doesn't match!");
        Assertions.assertTrue(driver.getPageSource().contains(context.aliasName), "Address name was not found!");
    }
}
