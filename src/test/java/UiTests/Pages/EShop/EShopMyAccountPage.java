package UiTests.Pages.EShop;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class EShopMyAccountPage extends BasePage {

    @FindBy(id = "field-address1")
    WebElement address1Input;

    @FindBy(id = "field-city")
    WebElement cityInput;

    @FindBy(id = "field-postcode")
    WebElement zipCodeInput;

    @FindBy(xpath = "//button[contains(.,'Save')]")
    WebElement saveAddressButton;

    @FindBy(id = "address-link")
    WebElement firstAddressButton;

    @FindBy(id = "addresses-link")
    WebElement addressButton;

    @FindBy(xpath = "//div[@class='addresses-footer']//span[contains(.,'Create new address')]")
    WebElement createAddressLink;

    @FindBy(xpath = "//li[contains(.,'Address successfully added!')]")
    WebElement addressConfirmationMessage;

    @FindBy(xpath = "//li[contains(.,'Address successfully deleted!')]")
    WebElement addressDeletionMessage;

    @FindBy(xpath = "//div[@class='col-lg-4 col-md-6 col-sm-6']//article[contains(@id,'address-')]/div[@class='address-body']")
    List<WebElement> addressList;

    @FindBy(xpath = "//div[@class='address-footer']/a[@data-link-action='delete-address']")
    List<WebElement> deleteAddressList;

    @FindBy(xpath = "//span[text()='Delete']")
    List<WebElement> deleteAddressButtons;

    @FindBy(xpath = "//span[contains(.,'Order history and details')]")
    WebElement orderHistoryOption;

    public EShopMyAccountPage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    public void fillsDetailsIntoNewAddress() {
        sendKeysToWebElement(address1Input, "123 Test Home Street");
        sendKeysToWebElement(zipCodeInput, "12345");
        sendKeysToWebElement(cityInput, "London");
    }

    public void saveNewAddress() {
        clickWebElement(saveAddressButton);
    }

    public void pressFirstAddressButton() {
        clickWebElement(firstAddressButton);
    }

    public void pressAddressButton() {
        clickWebElement(addressButton);
    }

    public void pressCreateAddressLink() {
        clickWebElement(createAddressLink);
    }

    public void pressDeleteAddress(int addressPosition) {
        wait.until(ExpectedConditions.elementToBeClickable(deleteAddressList.get(1)));
        WebElement deleteButton = deleteAddressList.get(1);
        clickWebElement(deleteButton);
    }

    public void validateAddedFirstAddress() {
        int addressCount = addressList.size();
        wait.until(ExpectedConditions.elementToBeClickable(addressList.get(0)));
        Assertions.assertEquals( 1,addressCount, "Address count does not match ...");
    }

    public void validateAddressDeleted() {
        wait.until(ExpectedConditions.elementToBeClickable(addressDeletionMessage));
        Assertions.assertTrue( addressDeletionMessage.isDisplayed(), "Deletion confirmation message missing ...");
    }

    public void validateFirstAddressDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(addressList.get(0)));
        Assertions.assertTrue(addressList.get(0).getText().contains("Johny"), "FirstName does not match ...");
        Assertions.assertTrue(addressList.get(0).getText().contains("Test"),"Surname does not match ...");
        Assertions.assertTrue(addressList.get(0).getText().contains("123 Test Home Street"),"Address does not match ...");
        Assertions.assertTrue(addressList.get(0).getText().contains("12345"),"ZipCode does not match ...");
        Assertions.assertTrue(addressList.get(0).getText().contains("London"),"City does not match ...");
    }

    public void validateAddressConfirmation() {
        wait.until(ExpectedConditions.elementToBeClickable(addressConfirmationMessage));
        Assertions.assertTrue(addressConfirmationMessage.isDisplayed(),"Address confirmation message not displayed ...");
    }

    public void pressOrderHistory() {
        clickWebElement(orderHistoryOption);
    }

    public void deleteAllAddressesButFirstOne() {
        for (int i = deleteAddressButtons.size() - 1; i > 0; i--) {
            clickWebElement(deleteAddressButtons.get(i));
            wait.until(ExpectedConditions.visibilityOf(addressDeletionMessage));
            driver.navigate().refresh();
        }
    }
}
