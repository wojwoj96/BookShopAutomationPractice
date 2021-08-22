package bookShop.selenium.integration.rules;

import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

import org.junit.Assert;



public class ConfigurationRules {

	  private static Properties properties = new Properties();

	    static {

	        if (Objects.isNull(System.getProperty("properties"))) {
	            System.setProperty("properties", "properties");
	        }

	        try (InputStream input = ConfigurationRules.class.getClassLoader().getResourceAsStream("config/" + System
	                .getProperty("properties"))) {
	            properties.load(input);
	        } catch (Exception e) {
	            Assert.fail("Initiall Selenium Configuration faild\n" + e);
	        }

	        for (Key key : Key.values()) {
	            setExternalProperty(key);
	        }
	    }
	
	    /**
	     * 
	     */
	    private static void setExternalProperty(final Key propertyKey) {

	        String property = System.getProperty(propertyKey.getKey());
	        if (null != property) {
	            properties.setProperty(propertyKey.getKey(), property);
	        }
	    }
	    
	    public static String get(final Key key) {

	        return properties.getProperty(key.getKey());
	    }
	    
	    public enum Key {

	        /**
	         * Dieses Feld enthält den Schlüssel zum benutzten Browser.
	         */
	        BROWSER_BROWSER("browser.browser"),

	        /**
	         * Dieses Feld enthält den Schlüssel zu Driverpfad.
	         */
	        BROWSER_DRIVERPATH("browser.driverpath"),

	        /**
	         * Dieses Feld enthält den Schlüssel zu Url-Adresse.
	         */
	        BROWSER_BASE_URL("browser.url");

			
	    	private String key;
	    	
	    	private Key(final String key) {
	    		this.key = key;		
	    		}
	    		    
	    	public String getKey() {
				return key;
			}
	    }
	    
}
