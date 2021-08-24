package bookShop.selenium.integration.integration;

import org.junit.AfterClass;
import org.junit.ClassRule;

import bookShop.selenium.integration.rules.BrowserRules;


/**
 * TODO
 */
public abstract class TestRules {
	
	/**
	 * TODO
	 */
	@ClassRule
	public static BrowserRules browserRules = new BrowserRules();
	
	/**
	 * TODO
	 */
	@AfterClass
	public static void tearDown() {

		UiBot.driver().quit();// TODO
	}
}
