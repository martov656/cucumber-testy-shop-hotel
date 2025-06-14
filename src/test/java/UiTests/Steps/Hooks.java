package UiTests.Steps;

import UiTests.Pages.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.maven.surefire.shared.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class Hooks {
    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before()
    public void before() throws IOException {
        this.loadConfigFile();
        ChromeOptions options = new ChromeOptions();
        if (isRunningInGithub() || context.configProperties.getProperty("isHeadless").equals("true")) {
            //WebDriverManager.chromedriver().clearDriverCache().setup();
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-gpu");
            // Generate UNIQUE temporary directory for user data
            //Path tempProfile = Files.createTempDirectory("chrome-profile-" + System.nanoTime());
            //options.addArguments("--user-data-dir=" + tempProfile.toAbsolutePath());
            context.driver = new ChromeDriver(options);
        } else {
            context.driver = new ChromeDriver();
        }
        context.driver = new ChromeDriver();
        context.pm = new PageManager(context);
        this.openOnSecondScreen_ForLecturerDemoOnly(context.driver);
    }

    @After()
    public void after(Scenario scenario) {
        waitBeforeClosing_ForLecturerDemoOnly();
        if (scenario.isFailed()) {
            this.takeScreenshot();
        }
        context.driver.quit();
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


    private void takeScreenshot() {
        String screenshotDir = System.getProperty("user.dir") + File.separator + "screenshots";
        File directory = new File(screenshotDir);
        if (!directory.exists()) {
            directory.mkdir();
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        File scrFile = ((TakesScreenshot) context.driver).getScreenshotAs(OutputType.FILE);
        // System.out.println(System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + "screenshot_" + timeStamp + ".png");
        try {
            FileUtils.copyFile(scrFile, new File(screenshotDir + File.separator + "screenshot_" + timeStamp + ".png"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
