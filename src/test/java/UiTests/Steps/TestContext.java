package UiTests.Steps;

import UiTests.Pages.PageManager;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class TestContext {

    public WebDriver driver;
    public PageManager pm;
    public Properties configProperties;

    public String email;
}
