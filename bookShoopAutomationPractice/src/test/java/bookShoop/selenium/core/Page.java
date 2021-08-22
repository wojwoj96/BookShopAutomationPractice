package bookShoop.selenium.core;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.github.webdriverextensions.WebSite;

import bookShop.selenium.integration.integration.UiBot;

public class Page extends WebSite{

	@FindBy(id = "site-logo")
    private WebElement logo;
	
	@FindBy(id = "main-nav")
    private MainMenueWebKomponent mainMenueWebKomponent;
	
	@FindBy(css = "main-nav")
    private NavigationMainMenu navigationMainMenu;
	
	public Page(final boolean init) {
    	initElements();
    	this.assertIsOpen();
    }
    
	public Page() {
		super();
	}
	
    public void refreshPage() {

        UiBot.driver().navigate().refresh();

        try {
            UiBot.driver().switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            e.getMessage();
        }

        UiBot.waitUntilWebElementVisible(logo, 5);
    }
	
    
    
    public MainMenueWebKomponent getMainMenueWebKomponent() {
    	return mainMenueWebKomponent;
    }
    
    
    public NavigationMainMenu getNavigationMainMenu() {
    	return navigationMainMenu;
    }

	@Override
	public void open(Object... arguments) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assertIsOpen(Object... arguments) throws AssertionError {
		// TODO Auto-generated method stub
		
	}
}
