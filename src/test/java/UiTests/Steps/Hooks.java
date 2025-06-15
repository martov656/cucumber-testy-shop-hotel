package UiTests.Steps;

import UiTests.Pages.BasePage;
import UiTests.Pages.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Hooks {
    private final TestContext context;
    private BasePage basePage;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before()
    public void before() throws IOException {
        this.loadConfigFile();
        ChromeOptions options = new ChromeOptions();
        if (isRunningInGithub() || context.configProperties.getProperty("isHeadless").equals("true")) {
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            context.driver = new ChromeDriver(options);
        } else if (context.configProperties.getProperty("isHeadless").equals("true")) {
            options.addArguments("--headless=new");
            context.driver = new ChromeDriver(options);
        } else {
            context.driver = new ChromeDriver();
        }
        context.pm = new PageManager(context);
        basePage = new BasePage(context);
        this.openOnSecondScreen_ForLecturerDemoOnly(context.driver);
    }

    @After()
    public void after(Scenario scenario) {
        waitBeforeClosing_ForLecturerDemoOnly();
        if (scenario.isFailed()) {
            basePage.takeScreenshot();
        }
        if (context.driver != null) {
            context.driver.quit();
        }
    }

    private boolean isRunningInGithub() {
        boolean inGithub = false;
        File file = new File(System.getProperty("user.dir") + File.separator + "runInGithub.txt");
        if (file.exists()) {
            context.configProperties.setProperty("isHeadless", "true");
            inGithub = true;
        }
        return inGithub;
    }

    private void loadConfigFile() {
        Properties configProperties;
        try {
            InputStream input = new FileInputStream("src/test/java/UiTests/Configs/courseConfig.properties");
            configProperties = new Properties();
            configProperties.load(input);
        } catch (IOException ex) {
            throw new Error("Config file not loaded ...");
        }
        context.configProperties = configProperties;
    }


    private void openOnSecondScreen_ForLecturerDemoOnly(WebDriver driver) {
        if (IsOnLecturerPc()) {
            driver.manage().window().setPosition(new Point(-2000, 0));
        }
    }

    private void waitBeforeClosing_ForLecturerDemoOnly() {
        if (IsOnLecturerPc()) {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean IsOnLecturerPc() {
        boolean inLecturerPc = false;
        File file = new File(System.getProperty("user.dir") + File.separator + "runInLecturerPc.txt");
        if (file.exists()) {
            inLecturerPc = true;
        }
        return inLecturerPc;
    }

}
