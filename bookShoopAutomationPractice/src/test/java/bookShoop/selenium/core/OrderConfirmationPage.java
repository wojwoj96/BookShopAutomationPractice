package bookShoop.selenium.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class OrderConfirmationPage extends Page{

	@FindBy(css = "#page-35 > div > div.woocommerce > p.woocommerce-thankyou-order-received")
    private WebElement confirmationText;

	@FindBy(css = "#page-35 > div > div.woocommerce > ul.woocommerce-thankyou-order-details.order_details > li.date > strong")
    private WebElement orderDate;
	
	private WebDriver driver;
	
	public OrderConfirmationPage(WebDriver driver){
	       this.driver=driver;
	       //Initialise Elements
	       PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	
	
	public String getconfirmationText() {

		   return confirmationText.getText();
    }
	
}
