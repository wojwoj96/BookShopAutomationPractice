package bookShoop.selenium.core;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationMainMenu extends PageObject{

	@FindBy(css = "#main-nav ul.main-nav > li")
    private List<WebElement> menueChoice;
	
		
	@FindBy(css = "ul#main-nav li:nth-of-type(1)")
	//@FindBy(css = "ul#main-nav li#menu-item-40")
    private WebElement shop;
	
	@FindBy(css = "ul#main-nav li:nth-of-type(2)")
    private WebElement myAccount;
	
	@FindBy(css = "ul#main-nav li:nth-of-type(6)")
    private WebElement shoppingCard;
	
	public NavigationMainMenu(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public WebElement getMenueChoice(int index) {
		return menueChoice.get(index);
	}
	
    public void chooseMainMenueCard(List<WebElement> menueChoice) {
    	int index = 0;
    	this.menueChoice.get(index).click();
    }
	
            
    public void goToOneOfMenuOption(final int index) {
		menueChoice.get(index).click();
		
	}

	@Override
	protected boolean istInitialisiert() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
