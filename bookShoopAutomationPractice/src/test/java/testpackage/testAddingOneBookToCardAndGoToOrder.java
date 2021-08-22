package testpackage;

import org.junit.Test;
import org.testng.AssertJUnit;

import bookShoop.selenium.core.HomePage;
import bookShoop.selenium.core.Page;
import bookShoop.selenium.core.ShoppingCardPage;
import bookShop.selenium.integration.rules.CollectorRules;

public class testAddingOneBookToCardAndGoToOrder extends CollectorRules{

	@Test
	public void testAddingOneBookToCardAndGoToOrder() {

		Page page = new Page(true);
			
		ShoppingCardPage shoppingCardPage = page.getNavigationMainMenu().chooseShoppingCardPage();	
		
		
	
	}
	
	private ShoppingCardPage openMainPage(final Page page) {

		HomePage homePage = page//
				.getNavigationMainMenu().chooseShoppingCardPage();//
					
		AssertJUnit.assertEquals(expected, actual);

		return new ShoppingCardPage(true);
	}
	
	
}
