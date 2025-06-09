package UiTests.Pages;

import UiTests.Steps.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected TestContext context;

    public BasePage(TestContext context) {
        this.context = context;
        this.driver = context.driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    protected void clickWebElement(WebElement element) {
        try {
            clickWebElementWithAction(element);
        } catch (WebDriverException e) {
            throw new Error("Element click failed ...");
        }
    }

    private void clickWebElementWithAction(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(element))).build().perform();
        element.click();
    }

    protected void sendKeysToWebElement(WebElement element, String text) {
        try {
            sendKeysToWebElementWithAction(element, text);
        } catch (WebDriverException e) {
            throw new Error("SendKeys to element failed ...");
        }
    }

    private void sendKeysToWebElementWithAction(WebElement element, String text) {
        Actions action = new Actions(driver);
        action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(element))).build().perform();
        element.sendKeys(text);
    }

    protected int getRandomNumber() {
        Random rand = new Random();
        int r = rand.nextInt(1000000);
        return r;
    }

}
