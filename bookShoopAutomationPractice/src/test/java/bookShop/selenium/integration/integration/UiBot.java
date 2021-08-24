package bookShop.selenium.integration.integration;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.webdriverextensions.Bot;

public class UiBot {

	public static WebDriver driver() {

        return Bot.driver();
    }
	
	private static Logger logger = LoggerFactory.getLogger(UiBot.class);

    public static JavascriptExecutor jsExecutor() {

        return (JavascriptExecutor) UiBot.driver();
    }

    public static void scrollDown() {

        jsExecutor().executeScript("window.scrollBy(0,1000)");
    }

    public static void scrollUp() {

        jsExecutor().executeScript("window.scrollBy(0,-1000)");
    }
    
    public static void waitUntilWebElementVisible(final WebElement webElement, int second) {

        WebDriverWait waiter = new WebDriverWait(UiBot.driver(), second);
        waiter.pollingEvery(Duration.ofMillis(200));
        waiter.until(ExpectedConditions.visibilityOf(webElement));
    }
     
    public static void waitForPageLoaded() {

        ExpectedCondition<Boolean> expectation = driver ->
            {
                String script = "var callback = arguments[arguments.length - 1];" + //
                "if (document.readyState !== 'complete') {" + //
                "  callback('document not ready');" + //
                "} else {" + //
                "  try {" + //
                "    var testabilities = window.getAllAngularTestabilities();" + //
                "    var count = testabilities.length;" + //
                "    var decrement = function() {" + //
                "      count--;" + //
                "      if (count === 0) {" + //
                "        callback('complete');" + //
                "      }" + //
                "    };" + //
                "    testabilities.forEach(function(testability) {" + //
                "      testability.whenStable(decrement);" + //
                "    });" + //
                "  } catch (err) {" + //
                "    callback(err.message);" + //
                "  }" + //
                "}";
                String result = UiBot.jsExecutor().executeAsyncScript(script).toString();
                logger.info("waitForPageLoaded: " + result);
                return result.equals("complete");
            };
        try {
            WebDriverWait wait = new WebDriverWait(Bot.driver(), 10);
            wait.pollingEvery(Duration.ofMillis(1000));
            wait.until(expectation);
        } catch (ScriptTimeoutException ss) {
            logger.info("Timeout ScriptTimeoutException.");
            waitForPageLoaded();
        } catch (Throwable error) {
            logger.info(error.getMessage());
            Assert.fail("Timeout waitForPageLoaded.");
        }

    }
    
    public static boolean istElementDisplayed(final WebElement webelement) {

        try {
            webelement.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean istElementAktiv(final WebElement webelement) {

        return Objects.isNull(webelement.getAttribute("disabled"));

    }
    
    public static String getTextFromHover() {

        UiBot.waitForPageLoaded();
        return UiBot.driver().findElement(By.cssSelector("")).getText();

    }
            
    /**
     * Helping method to be sure, that the website is stable and the test can go on.
     */
    public static void waitUntilPageWillBeReady() {

        try {
            WebDriverWait waiter = new WebDriverWait(UiBot.driver(), 2);
            waiter.pollingEvery(Duration.ofMillis(200));
            waiter.until(driver -> driver.findElements(By.cssSelector(".input-spinner")).isEmpty());
        } catch (Throwable error) {
            Assert.fail("Timeout");
        }
    }
}
