package bookShoop.selenium.core;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {

	private WebDriver driver;

    /**
     * Erzeugt eine neue Instanz.
     * 
     * @param driver {@link #driver}
     */
    public PageObject(WebDriver driver) {

        this(driver, true);
    }

    /**
     * Erzeugt eine neue Instanz.
     * 
     * @param driver {@link #driver}
     * @param initElemente ob Elemente von {@link PageFactory} initialisiert werden sollen
     */
    public PageObject(WebDriver driver, boolean initElemente) {

        this.driver = driver;

        if (initElemente) {
            PageFactory.initElements(driver, this);

            assertTrue(istInitialisiert());
        }
    }
    
    protected static void sendNew(WebElement webElement, String newValue) {

        webElement.clear();

        if (StringUtils.isNotEmpty(newValue)) {
            webElement.sendKeys(newValue);
        }
    }
    
    protected abstract boolean istInitialisiert();
}
