package UiTests.Steps;

import UiTests.Pages.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before()
    public void before(){
      context.driver = new ChromeDriver();
      context.pm = new PageManager(context);
    }

    @After()
    public void after(){
        context.driver.quit();
    }
}
