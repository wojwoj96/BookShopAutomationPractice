package bookShoop.selenium.core;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.github.webdriverextensions.WebComponent;

public class MainMenueWebKomponent extends WebComponent{

	
	@FindBy(css = "#main-nav ul.main-nav > li")
    private List<WebElement> menueChoice;
	
		
	@FindBy(css = "ul#main-nav li:nth-of-type(1)")
	//@FindBy(css = "ul#main-nav li#menu-item-40")
    private WebElement shop;
	
	
	@FindBy(css = "ul#main-nav li:nth-of-type(6)")
    private WebElement shoppingCard;
	
	public WebElement getMenueChoice(int index) {
		return menueChoice.get(index);
	}
	
	public void goToOneOfMenuOption(final int index) {
		menueChoice.get(index).click();
		
	}
	
    public void chooseMainMenueCard(List<WebElement> menueChoice) {
    	int index = 0;
    	this.menueChoice.get(index).click();
    }
}

