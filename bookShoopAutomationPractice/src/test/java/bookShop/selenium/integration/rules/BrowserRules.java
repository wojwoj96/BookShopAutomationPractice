package bookShop.selenium.integration.rules;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.webdriverextensions.WebDriverExtensionsContext;

import bookShop.selenium.integration.rules.ExternalConfiguration.Key;

public class BrowserRules extends ExternalResource{

	/**
     * This Field define waitingtime.
     */
	public static final long TIME = 5;
	
	
	private static WebDriver driver;
	
	private ExternalConfiguration externalConfiguration;
	
	public BrowserRules(ExternalConfiguration externalConfiguration) {
		this.externalConfiguration = externalConfiguration;
	}
	
	public BrowserRules() {
		// TODO Auto-generated constructor stub
	}

	public WebDriver getDriver() {

        return this.driver;
    }
	
	protected void before() throws Throwable {

        String driverPath = ExternalConfiguration.get(Key.BROWSER_DRIVERPATH);
        boolean isRemotePath = driverPath.toLowerCase().startsWith("http://");
        switch (ExternalConfiguration.get(Key.BROWSER_BROWSER)) {
        
        case "CHROME":

            if (isRemotePath) {
                driver = new RemoteWebDriver(new URL(driverPath), DesiredCapabilities.chrome());
            } else {
                System.setProperty("webdriver.chrome.driver", //
                		ExternalConfiguration.get(Key.BROWSER_DRIVERPATH));

                driver = new ChromeDriver();
            }
            break;
        
            case "FIREFOX":

                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                final FirefoxOptions firefoxOptions = new FirefoxOptions(capabilities);

                if (isRemotePath) {
                    firefoxOptions.setHeadless(true);
                    driver = new RemoteWebDriver(new URL(driverPath), firefoxOptions);
                } else {
                    System.setProperty("webdriver.gecko.driver", //
                    		ExternalConfiguration.get(Key.BROWSER_DRIVERPATH));

                    firefoxOptions.setHeadless(false);
                    driver = new FirefoxDriver(firefoxOptions);
                }
                break;
            
            
            default:
                Assert.fail("Configuration is not supported!");
        }

        driver.manage().timeouts().implicitlyWait(TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(TIME, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1280, 1024));

        WebDriverExtensionsContext.setDriver(driver);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void after() {

        driver.quit();
    }
}
