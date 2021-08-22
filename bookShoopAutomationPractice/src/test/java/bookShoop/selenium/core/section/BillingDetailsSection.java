package bookShoop.selenium.core.section;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bookShoop.selenium.core.CheckOrderPage;
import bookShoop.selenium.core.Section;

public class BillingDetailsSection extends Section{

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
    private WebElement country;
	
	@FindBy(id = "billing_address_1")
    private WebElement billingAddress1;
	
	@FindBy(id = "billing_address_2")
    private WebElement billing_Address2;
	
	@FindBy(id = "billing_postcode")
    private WebElement billingPostcode;
	
	@FindBy(id = "billing_city")
    private WebElement billingCity;
	
	public BillingDetailsSection(WebDriver driver) {
		super(driver);
	}
	
	
}
