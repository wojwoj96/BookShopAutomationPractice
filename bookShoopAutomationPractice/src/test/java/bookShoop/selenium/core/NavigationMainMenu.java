package bookShoop.selenium.core;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationMainMenu extends Page{

	@FindBy(css = "#main-nav ul.main-nav > li")
    private List<WebElement> menueChoice;
				
	@FindBy(css = "ul#main-nav li:nth-of-type(1)")
    private WebElement shop;
		
	@FindBy(css = "ul#main-nav li:nth-of-type(6)")
    private WebElement shoppingCard;
	
	@FindBy(css = "ul#main-nav li:nth-of-type(1)")
    private ShopPage shop1;
		
	@FindBy(css = "ul#main-nav li:nth-of-type(6)")
    private ShoppingCardPage shoppingCard1;
	
	public NavigationMainMenu(WebDriver driver) {
		super(driver);
		
	}
		
	public ShopPage goToShopPage() {
		return shop1;
		
	}
	
	public ShoppingCardPage goToShoppingPage() {
		
		return shoppingCard1;
	}
	public void goToOneOfMenuOption(final int index) {
		menueChoice.get(index).click();
		
	}
			
    public void chooseMainMenueCard(List<WebElement> menueChoice) {
    	int index = 0;
    	this.menueChoice.get(index).click();
    }
	
	
}
