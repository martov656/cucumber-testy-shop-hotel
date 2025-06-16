package UiTests.Steps;

import UiTests.Pages.PageManager;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class TestContext {

    public WebDriver driver;
    public PageManager pm;
    public Properties configProperties;

    public String email;
    public String aliasName;

    public String orderReference;
    public String orderTotal;
    public String orderHistoryStatus;
    public String orderHistoryPrice;

}
