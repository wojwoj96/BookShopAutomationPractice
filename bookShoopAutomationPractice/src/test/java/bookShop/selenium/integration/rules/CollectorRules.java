package bookShop.selenium.integration.rules;

import org.junit.ClassRule;

public abstract class CollectorRules {

	/**
	 * Dieses Feld enthält den {@link BrowserRegel}.
	 */
	@ClassRule
	public static BrowserRules browserRules = new BrowserRules();
}
