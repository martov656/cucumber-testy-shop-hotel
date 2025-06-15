package UiTests.Pages.Hotel;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HotelResultsPage extends BasePage {
    public HotelResultsPage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }


    // *********************** Elements *************************************
    @FindBy(xpath = "//div/p[text()='Sort By:']")
    WebElement labelSortBy;

    @FindBy(xpath = "//span[text()='Book Now']")
    List<WebElement> bookNowButton;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement proceedToCheckout;


    // *********************** Methods *************************************

    public void verifyHotelsSearch() {

        try {
            wait.until(ExpectedConditions.urlContains("14-the-hotel-prime"));
        } catch (Exception e) {
            Assertions.fail("The Hotel Prime is not in url ...");
        }
        try {
            wait.until(ExpectedConditions.visibilityOf(labelSortBy));
        } catch (Exception e) {
            Assertions.fail("User hotels not searched ...");
        }

        boolean cond1 = driver.getPageSource().contains("Delux Rooms");
        boolean cond2 = driver.getPageSource().contains("Executive Rooms");
        boolean cond3 = driver.getPageSource().contains("luxury Rooms");
        boolean cond4 = driver.getPageSource().contains("General Rooms");
        // we validate if at least one room is found
        Assertions.assertTrue(cond1 || cond2 || cond3 || cond4, "No proper rooms found ...");
    }

    public void clickOnTheFirstBookButton() {
        this.verifyHotelsSearch();
        this.clickWebElement(this.bookNowButton.getFirst());
    }

    public void clickOnTheProceedToCheckoutButton() {
        this.clickWebElement(this.proceedToCheckout);
    }

}
