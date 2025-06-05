package UiTests.Pages;

import UiTests.Steps.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected TestContext context;

    public BasePage(TestContext context) {
        this.context = context;
        this.driver = context.driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }
}
