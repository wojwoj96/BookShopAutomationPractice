package bookShoop.selenium.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bookShoop.selenium.core.section.AdditionalInformationSection;
import bookShoop.selenium.core.section.BankTransferSection;
import bookShoop.selenium.core.section.BillingDetailsSection;
import bookShoop.selenium.core.section.YourOrderSection;

public class CheckOrderPage extends Page{
	
	@FindBy(id = "place_order")
    private WebElement placeOrderButton;
	
	@FindBy(css = "#customer_details > div.col-2 > div")
    private AdditionalInformationSection additionalInformationSection;

	@FindBy(css = "#payment > ul")
    private BankTransferSection bankTransferSection;
	
	@FindBy(css = "#customer_details > div.col-1 > div")
    private BillingDetailsSection billingDetailsSection;
	
	@FindBy(css = "")
    private YourOrderSection yourOrderSection;

	private WebDriver driver;
	
	public CheckOrderPage(WebDriver driver){
	       this.driver=driver;

	       //Initialise Elements
	       PageFactory.initElements(driver, this);
	   }
	
	public AdditionalInformationSection getAdditionalInformationSection() {
		return additionalInformationSection;
	}
	
	public BankTransferSection getBankTransferSection() {
		return bankTransferSection;
	}
	
	public BillingDetailsSection getBillingDetailsSection() {
		return billingDetailsSection;		
	}
	
	public void placeOrder() {
		this.placeOrderButton.click();
	}
}
