package bookShoop.selenium.core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends Page{

	@FindBy(css = "#page-35 > div > div.woocommerce > p.woocommerce-thankyou-order-received")
    private WebElement confirmationText;

	@FindBy(css = "#page-35 > div > div.woocommerce > ul.woocommerce-thankyou-order-details.order_details > li.date > strong")
    private WebElement orderDate;
	
	public String getconfirmationText() {

        return confirmationText.getText();
    }

	public boolean isOrderConfirm(){
	       
	       return confirmationText.getText().toString().contains("Thank you. Your order has been received.");
	   }
}
