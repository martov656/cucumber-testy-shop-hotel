package UiTests.Steps;

import UiTests.Pages.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Hooks {
    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before()
    public void before(){
      this.loadConfigFile();
      context.driver = new ChromeDriver();
      context.pm = new PageManager(context);
      this.openOnSecondScreen_ForLecturerDemoOnly(context.driver);
    }

    @After()
    public void after(){
        waitBeforeClosing_ForLecturerDemoOnly();
        context.driver.quit();
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
