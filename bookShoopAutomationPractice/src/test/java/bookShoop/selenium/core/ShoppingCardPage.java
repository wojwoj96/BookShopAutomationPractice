package bookShoop.selenium.core;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCardPage extends Page{

	@FindBy(css = "#page-34 > div > div.woocommerce > form > table > tbody > tr.cart_item > td.product-name > a")
    private List<WebElement> productNameInTheBasketCss;
	
	@FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[3]/a")
    private WebElement productNameInTheBasketXpath;
		
	@FindBy(id = "coupon_code")
    private WebElement couponCodeInput;
	
	
	@FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[2]/td/input[1]")
    private WebElement updateButtonXpath;
	
	@FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/div[2]/div/div/a")
    private WebElement proceedToCheckoutButtonXpath;
	
	public void proceedToCheckout() {
		this.proceedToCheckoutButtonXpath.click();
	}
	
	
}
