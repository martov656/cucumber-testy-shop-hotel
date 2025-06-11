package UiTests.Pages.Hotel;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotelNewAddressesPage extends BasePage {
    public HotelNewAddressesPage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    // *********************** Elements *************************************

    @FindBy(id = "firstname")
    WebElement firstnameInput;

    @FindBy(id = "lastname")
    WebElement lastnameInput;

    @FindBy(id = "address1")
    WebElement address1Input;

    @FindBy(id = "address2")
    WebElement address2Input;

    @FindBy(id = "postcode")
    WebElement postcodeInput;

    @FindBy(id = "city")
    WebElement cityInput;

    @FindBy(id = "phone")
    WebElement phoneInput;

    @FindBy(id = "phone_mobile")
    WebElement phoneMobileInput;

    @FindBy(id = "alias")
    WebElement aliasNameInput;

    @FindBy(id = "submitAddress")
    WebElement submitAddressButton;

    // *********************** Methods *************************************

    public void fillAddress(String address1, String address2, String postcode, String city, String phone, String mobile, String alias) {
        this.sendKeysToWebElement(address1Input, address1);
        this.sendKeysToWebElement(address2Input, address2);
        this.sendKeysToWebElement(postcodeInput, postcode);
        this.sendKeysToWebElement(cityInput, city);
        this.sendKeysToWebElement(phoneInput, phone);
        this.sendKeysToWebElement(phoneMobileInput, mobile);
        wait.until(ExpectedConditions.elementToBeClickable(this.aliasNameInput));
        this.aliasNameInput.clear();
        context.aliasName = alias + " " + this.getRandomNumber(1000);
        this.sendKeysToWebElement(aliasNameInput, context.aliasName);
    }

    public void saveAddress() {
        this.clickWebElement(submitAddressButton);
    }
}
