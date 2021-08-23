package bookShoop.selenium.core;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bookShop.selenium.integration.integration.UiBot;

public class ShoppingCardPage extends Page{

	@FindBy(css = "#page-34 > div > div.woocommerce > form > table > tbody > tr.cart_item > td.product-name > a")
    private List<WebElement> productNameInTheBasketCss;
	
	@FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[3]/a")
    private WebElement productNameInTheBasketXpath;
		
	@FindBy(id = "coupon_code")
    private WebElement couponCodeInput;
	
	
	@FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[2]/td/input[1]")
    private WebElement updateButtonXpath;
	
	@FindBy(css = "#page-34 > div > div.woocommerce > div > div > div > a")
    private WebElement proceedToCheckoutButtonXpath;
	
	private WebDriver driver;
	
	public ShoppingCardPage(WebDriver driver){
	       this.driver=driver;
	       //UiBot.waitForPageLoaded();
	       //Initialise Elements
	       PageFactory.initElements(driver, this);
	       
	   }
	
	//To check if page is opened and has added book.
	   public boolean isPageOpened(){
	       return productNameInTheBasketXpath.getText().toString().contains("Selenium Ruby");
	   }
	
	   
	   
	public CheckOrderPage proceedToCheckout() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//UiBot.waitForPageLoaded();
		this.proceedToCheckoutButtonXpath.click();
		return new CheckOrderPage(driver);
	}
	
	
	
}
