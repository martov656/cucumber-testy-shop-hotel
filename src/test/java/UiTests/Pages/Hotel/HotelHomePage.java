package UiTests.Pages.Hotel;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @FindBy(id = "hotel_location")
    WebElement hotelLocation;

    @FindBy(xpath = "//button/span[@id='hotel_cat_name']")
    WebElement hotelCategory;

    @FindBy(id = "check_in_time")
    WebElement checkInDate;

    @FindBy(id = "check_out_time")
    WebElement checkOutDate;

    @FindBy(id = "search_room_submit")
    WebElement searchHotel;





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

    public void enterHotelLocationAndName (String hotelLocation, String hotelName){
        this.sendKeysToWebElement(this.hotelLocation,hotelLocation);
        this.clickWebElement(hotelCategory);
        WebElement element = driver.findElement(By.xpath("//ul[@class='dropdown-menu hotel_dropdown_ul']/li[text()='"+hotelName+"']"));
        element.click();
    }
    public void hotelCheckinCheckout (){
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date dt = new Date();
        String dataIn = df.format(dt);
        String dataOut = df.format(new Date(dt.getTime() + (2 * 1000 * 60 * 60 * 24)));
        this.sendKeysToWebElement(this.checkInDate, dataIn);
        this.sendKeysToWebElement(this.checkOutDate, dataOut);
    }
    public void searchHotelClick (){
        clickWebElement(this.searchHotel);
    }
}




