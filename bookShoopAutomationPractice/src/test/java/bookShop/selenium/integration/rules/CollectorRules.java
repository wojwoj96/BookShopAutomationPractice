package bookShop.selenium.integration.rules;

import org.junit.ClassRule;

public abstract class CollectorRules {

	/**
	 * Dieses Feld enth�lt den {@link BrowserRegel}.
	 */
	@ClassRule
	public static BrowserRules browserRules = new BrowserRules();
}
