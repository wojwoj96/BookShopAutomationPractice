package bookShoop.selenium.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class HomePage extends Page {
		

	public HomePage(WebDriver driver){
	       this.driver=driver;
	       driver.get(PageUrl);
	       //Initialise Elements
	       PageFactory.initElements(driver, this);
	}

	@FindBy(id = "searchform")
    private WebElement searchform;
		
	@FindBy(xpath = "//*[@id=\"text-22-sub_row_1-0-2-0-0\"]/div/ul/li/a[2]")
    private WebElement addToBasketButton;
	
	@FindBy(xpath = "//*[@id=\"text-22-sub_row_1-0-2-0-0\"]/div/ul/li/a[3]")
    private WebElement viewBasketButton;
	
	@FindBy(id = "main-nav")
    private NavigationMainMenu navigationMainMenu;
    
	@FindBy(xpath = "//*[@id=\"wpmenucartli\"]/a")
    private WebElement shoppingCardButton;
	
    public void isMainPageReadyToUse() {
    	
    }

    public void addBookToBasket() {
    	this.addToBasketButton.click();
    	
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    
    public ShoppingCardPage checkShoppingCard() {
    	this.shoppingCardButton.click();
    	return new ShoppingCardPage(driver);
    }
    
    public ShoppingCardPage goToShoppingCardPage() {
    	this.shoppingCardButton.click();
    	return new ShoppingCardPage(driver);
    }
        
    ///////////////////////////////////////////77
    private WebDriver driver;
    
    private static String PageUrl ="http://practice.automationtesting.in/";
    
    
}
