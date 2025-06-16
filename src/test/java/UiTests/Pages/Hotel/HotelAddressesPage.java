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

    @FindBy(id = "address1")
    WebElement address1Input;

    @FindBy(id = "postcode")
    WebElement zipCodeInput;

    @FindBy(id = "city")
    WebElement cityInput;

    @FindBy(id = "phone")
    WebElement phoneInput;

    @FindBy(id = "phone_mobile")
    WebElement mobileInput;

    @FindBy(xpath = "//div[@id='adress_alias']/input")
    WebElement aliasNameInput;

    @FindBy(id = "submitAddress")
    WebElement submitAddressButton;

    @FindBy(xpath = "//span[@class='address_name']")
    List<WebElement> namesList;

    @FindBy(xpath = "//div[@class='col-xs-12 col-sm-12 address']")
    List<WebElement> addressList;


    // *********************** Methods *************************************

    public void fillInAddressForm() {
        this.sendKeysToWebElement(this.address1Input, "Street 123");
        this.sendKeysToWebElement(this.cityInput, "Krakow");
        this.sendKeysToWebElement(this.zipCodeInput, "60600");
        this.sendKeysToWebElement(this.phoneInput, "123456");
        this.sendKeysToWebElement(this.mobileInput, "654321");
        this.sendKeysToWebElement(this.aliasNameInput, "myFirstAddress");
    }


    public void validateAddressCreated() {
        try {
            wait.until(ExpectedConditions.visibilityOf(this.addressList.get(addressList.size() - 1)));
        } catch (Exception e) {
            Assertions.fail("Address has not been created.");
        }
        Assertions.assertEquals(1, addressList.size(), "Address count doesn't match!");
        Assertions.assertTrue(driver.getPageSource().contains(context.aliasName), "Address name was not found!");
    }
}
