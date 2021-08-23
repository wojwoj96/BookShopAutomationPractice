package bookShoop.selenium.core;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bookShoop.selenium.core.section.AdditionalInformationSection;
import bookShoop.selenium.core.section.BankTransferSection;
import bookShoop.selenium.core.section.BillingDetailsSection;
import bookShoop.selenium.core.section.YourOrderSection;
import bookShop.selenium.integration.integration.UiBot;

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

	@FindBy(id = "billing_first_name")
    private WebElement billingFirstName;
		
	@FindBy(id = "billing_last_name")
    private WebElement billingLastName;
	
	@FindBy(id = "billing_company")
    private WebElement billingCompany;
	
	@FindBy(id = "billing_email")
    private WebElement billingEmail;
	
	@FindBy(id = "billing_phone")
    private WebElement billingPhone;
	
	@FindBy(id = "select2-chosen-1")
    private WebElement billingCountry;
	
	@FindBy(id = "billing_address_1")
    private WebElement billingAddress1;
	
	@FindBy(id = "billing_address_2")
    private WebElement billing_Address2;
	
	@FindBy(id = "billing_postcode")
    private WebElement billingPostcode;
	
	@FindBy(id = "billing_city")
    private WebElement billingCity;
	
	
private WebDriver driver;
	
public void checkInputIsRequired() {
	
}
	
	public void setBillingFirstName(String name){
		this.billingFirstName.isDisplayed();
		this.billingFirstName.clear();
		this.billingFirstName.sendKeys(name);
	   }
	
	public void setBillingLastName(String lastName){
		this.billingLastName.isDisplayed();
		this.billingLastName.clear();
		this.billingLastName.sendKeys(lastName);
	   }
	
	public void setBillingEmail(String email){
		this.billingEmail.isDisplayed();
		this.billingEmail.clear();
		this.billingEmail.sendKeys(email);
	   }
	
	public void setBillingPhone(String phone){
		this.billingPhone.isDisplayed();
		this.billingPhone.clear();
		this.billingPhone.sendKeys(phone);
	   }
	
	public void setBillingCountry(String country){
		this.billingCountry.isDisplayed();
		this.billingCountry.clear();
		this.billingCountry.sendKeys(country);
	   }
	
	public void setBillingAddress1(String adress1){
		this.billingAddress1.isDisplayed();
		this.billingAddress1.clear();
		this.billingAddress1.sendKeys(adress1);
	   }
	
	public void setBillingPostcode(String code){
		this.billingPostcode.isDisplayed();
		this.billingPostcode.clear();
		this.billingPostcode.sendKeys(code);
	   }
	
	public void setBillingCity(String city){
		this.billingCity.isDisplayed();
		this.billingCity.clear();
		this.billingCity.sendKeys(city);
	   }
	
	public CheckOrderPage(WebDriver driver){
	       this.driver=driver;
	       //UiBot.waitForPageLoaded();
	       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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
	
	public OrderConfirmationPage placeOrder() {
		this.placeOrderButton.isDisplayed();
		this.placeOrderButton.click();
		return new OrderConfirmationPage(driver);
	}
	
	
	
}
