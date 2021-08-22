package bookShop.selenium.integration.integration;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.webdriverextensions.Bot;

public class UiBot {

	public static WebDriver driver() {

        return Bot.driver();
    }

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

        WebDriverWait warter = new WebDriverWait(UiBot.driver(), second);
        warter.pollingEvery(Duration.ofMillis(200));
        warter.until(ExpectedConditions.visibilityOf(webElement));
    }
     
    
}
