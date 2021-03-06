package bookShop.selenium.integration.rules;

import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

import org.junit.Assert;



public class ExternalConfiguration {

	  private static Properties properties = new Properties();

	    static {

	        if (Objects.isNull(System.getProperty("properties"))) {
	            System.setProperty("properties", "properties");
	        }

	        try (InputStream input = ExternalConfiguration.class.getClassLoader().getResourceAsStream("config/" + System
	                .getProperty("properties"))) {
	            properties.load(input);
	        } catch (Exception e) {
	            Assert.fail("Initiall Selenium Configuration faild\n" + e);
	        }
	        
	            setExternalProperty(Key.BROWSER_BASE_URL);
	            setExternalProperty(Key.BROWSER_BROWSER);
	            setExternalProperty(Key.BROWSER_DRIVERPATH);
	        
	    }
	
	    /**
	     * 
	     */
	    private static void setExternalProperty(Key propertyKey) {

	        String property = System.getProperty(propertyKey.getKey());
	        if (null != property) {
	            properties.setProperty(propertyKey.getKey(), property);
	        }
	    }
	    
	    public static String get(Key key) {

	        return properties.getProperty(key.getKey());
	    }
	    
	    public enum Key {

	        /**
	         * Dieses Feld enth?lt den Schl?ssel zum benutzten Browser.
	         */
	        BROWSER_BROWSER("browser.browser"),

	        /**
	         * Dieses Feld enth?lt den Schl?ssel zu Driverpfad.
	         */
	        BROWSER_DRIVERPATH("browser.driverpath"),

	        /**
	         * Dieses Feld enth?lt den Schl?ssel zu Url-Adresse.
	         */
	        BROWSER_BASE_URL("browser.url");

			
	    	private String key;
	    	
	    	private Key(final String key) {
	    		this.key = key;		
	    		}
	    		    
	    	public String getKey() {
				return this.key;
			}
	    }
	    
}
