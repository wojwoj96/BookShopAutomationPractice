package bookShoop.selenium.core;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bookShop.selenium.integration.integration.UiBot;

public abstract class HomePage extends Page {
		

	public HomePage(boolean init) {
		super(init);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "searchform")
    private WebElement searchform;
		
	@FindBy(id = "")
    private WebElement addToBasketButton;
	
	@FindBy(id = "main-nav")
    private MainMenueWebKomponent mainMenueWebKomponent;
       
        
    public void isMainPageReadyToUse() {
    	
    }

    public void addBookToBasket() {
    	
    }
    
        
}
