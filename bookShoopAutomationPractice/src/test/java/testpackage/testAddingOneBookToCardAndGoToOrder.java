package testpackage;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

import bookShoop.selenium.core.CheckOrderPage;
import bookShoop.selenium.core.HomePage;
import bookShoop.selenium.core.OrderConfirmationPage;
import bookShoop.selenium.core.ShoppingCardPage;
import bookShop.selenium.integration.integration.AssertionHelper;
import bookShop.selenium.integration.integration.UiBot;
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
		//Assert.assertTrue(home.isPageOpened());
		ShoppingCardPage shoppingCardPage = home.viewShoppingCard();
		
		Assert.assertTrue(shoppingCardPage.isPageOpened());
		
		
		CheckOrderPage checkOrderPage = shoppingCardPage.proceedToCheckout();
		//Assert.assertTrue(checkOrderPage.isPageOpened());

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		checkOrderPage.placeOrder();
		
		//AssertionHelper.assertValidation(
			//	Arrays.asList(), actuall);
		
		
		
		//checkOrderPage.setBillingFirstName("");
		//checkOrderPage.setBillingLastName("");
		//checkOrderPage.setBillingEmail("");
		//checkOrderPage.setBillingPhone("");
		//checkOrderPage.setBillingCountry("");
		//checkOrderPage.setBillingAddress1("");
		//checkOrderPage.setBillingPostcode("");
		//checkOrderPage.setBillingCity("");
		
		
		
		checkOrderPage.setBillingFirstName("Matii");
		checkOrderPage.setBillingLastName("Smith");
		checkOrderPage.setBillingEmail("matismith@gmail.com");
		checkOrderPage.setBillingPhone("111111111");
		//checkOrderPage.setBillingCountry("");
		checkOrderPage.setBillingAddress1("a");
		checkOrderPage.setBillingPostcode("22222");
		checkOrderPage.setBillingCity("wawa");
		
		
		OrderConfirmationPage orderConfirmationPage = checkOrderPage.placeOrder();
		//Assert.assertTrue(UiBot.waitForPageLoaded());
		
		Assert.assertEquals("Thank you. Your order has been received.", orderConfirmationPage.getconfirmationText());
		
		driver.close();
	}
	
	
	
	
}
