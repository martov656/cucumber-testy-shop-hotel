package UiTests.Pages.Hotel;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelHomePage extends BasePage {
    public HotelHomePage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    // *********************** Elements *************************************

    @FindBy(xpath = "//span[text()='Sign in']")
    WebElement signInLink;

    @FindBy (id = "user_info_acc")
    WebElement UserDropDownHover;

    @FindBy (xpath = "//a[text()='Logout']")
    WebElement LogoutOption;




    // *********************** Methods **************************************

    public void loadHomePage() {
        driver.manage().window().maximize();
        driver.get(context.configProperties.getProperty("hotelUrl"));
    }

    public void clickSignIn() {
        this.clickWebElement(this.signInLink);
    }


    public void logoutUser() {
        this.clickWebElement(UserDropDownHover);
        this.clickWebElement(LogoutOption);
    }

    public void logoinUser() {
        this.clickWebElement(UserDropDownHover);
    }

}




