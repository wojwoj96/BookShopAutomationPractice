package testpackage;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import bookShoop.selenium.core.CheckOrderPage;
import bookShoop.selenium.core.HomePage;
import bookShoop.selenium.core.ShoppingCardPage;
import bookShop.selenium.integration.rules.CollectorRules;

public class testAddingOneBookToCardAndGoToOrder extends CollectorRules{

	WebDriver driver ;
	
	@Before
	   public void setup(){
  
	       //String driverPath = "C:\\BookShopAutomationPractice\\BookShopAutomationPractice\\chromedriver_92.0.4515.107.exe";
	       //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   }
	
	@Test
	public void testAddingOneBookToCardAndGoToOrder() {

		driver = new ChromeDriver();  
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
		driver.manage().window().maximize();  
		HomePage home = new HomePage(driver) {
		};
		
		home.addBookToBasket();
		
		ShoppingCardPage shoppingCardPage = home.checkShoppingCard();
		
		Assert.assertTrue(shoppingCardPage.isPageOpened());
		
		
		CheckOrderPage checkOrderPage = shoppingCardPage.proceedToCheckout();
		//Assert.assertTrue(checkOrderPage.isPageOpened());

		checkOrderPage.getBillingDetailsSection().setBillingFirstName("Matii");
		checkOrderPage.getBillingDetailsSection().setBillingLastName("Smith");
		
	
	}
	
	
	
	
}
