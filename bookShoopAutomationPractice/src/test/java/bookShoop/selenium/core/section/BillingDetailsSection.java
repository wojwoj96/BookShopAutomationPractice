package bookShoop.selenium.core.section;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bookShoop.selenium.core.CheckOrderPage;
import bookShoop.selenium.core.Section;

public class BillingDetailsSection {

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
	
	//public BillingDetailsSection(WebDriver driver) {
		//super(driver);
	//}
	
private WebDriver driver;
	
	public BillingDetailsSection(WebDriver driver){
	       this.driver=driver;

	       //Initialise Elements
	       PageFactory.initElements(driver, this);
	   }
	
	public void setBillingFirstName(String name){
		this.billingFirstName.isDisplayed();
		this.billingFirstName.clear();
		this.billingFirstName.sendKeys(name);
	   }
	
	public void setBillingLastName(String lastName){
		billingLastName.clear();
		billingLastName.sendKeys(lastName);
	   }
	
	public void setBillingEmail(String email){
		billingEmail.clear();
		billingEmail.sendKeys(email);
	   }
	
	public void setBillingPhone(String phone){
		billingPhone.clear();
		billingPhone.sendKeys(phone);
	   }
	
	public void setBillingCountry(String country){
		billingCountry.clear();
		billingCountry.sendKeys(country);
	   }
	
	public void setBillingAddress1(String adress1){
		billingAddress1.clear();
		billingAddress1.sendKeys(adress1);
	   }
	
	public void setBillingPostcode(String code){
		billingPostcode.clear();
		billingPostcode.sendKeys(code);
	   }
	
	public void setBillingCity(String city){
		billingCity.clear();
		billingCity.sendKeys(city);
	   }
	
}
