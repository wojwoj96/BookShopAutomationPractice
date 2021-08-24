package bookShoop.selenium.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.github.webdriverextensions.Bot;

import bookShoop.selenium.core.section.AdditionalInformationSection;
import bookShoop.selenium.core.section.BankTransferSection;
import bookShoop.selenium.core.section.BillingDetailsSection;
import bookShoop.selenium.core.section.YourOrderSection;

public class CheckOrderPage extends Page {

	@FindBy(css = "#page-35 > div > div.woocommerce > form.checkout.woocommerce-checkout > ul >li")
	private List<WebElement> requiredFieldList;

	@FindBy(id = "createaccount")
	private WebElement createAccount;

	@FindBy(id = "payment_method_bacs")
	private WebElement directBankTransferOption;

	@FindBy(id = "account_password")
	private WebElement accountPasswordInput;

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

	@FindBy(xpath = "//*[@id=\"payment\"]/ul/li[1]/div/p")
	private WebElement directBankTransferMessage;

	private WebDriver driver;

	public CheckOrderPage(WebDriver driver) {
		this.driver = driver;
		// UiBot.waitForPageLoaded();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// Initialise Elements
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}

	public List<String> getRequiredFieldList() {

		List<String> list = new ArrayList<String>();

		for (WebElement fieldElement : requiredFieldList) {
			list.add(fieldElement.getText());
		}
		return list;
	}

	public String isCheckboxSelected() {

		return Bot.valueIn(this.createAccount);
	}

	public boolean isCheckboxCreateAccountAktiv() {

		return createAccount.isEnabled();
	}

	public boolean isCheckboxCreateAccountSelected() {

		return createAccount.isSelected();
	}

	public boolean isRadiobuttonDirectBankTransferAktiv() {

		return directBankTransferOption.isEnabled();
	}

	public boolean isRadiobuttonDirectBankTransferSelected() {

		return directBankTransferOption.isSelected();
	}

	public String getDirectBankTransferText() {

		return directBankTransferMessage.getText();
	}

	public void setBillingFirstName(String name) {
		this.billingFirstName.isDisplayed();
		this.billingFirstName.clear();
		this.billingFirstName.sendKeys(name);
	}

	public void setBillingLastName(String lastName) {
		this.billingLastName.isDisplayed();
		this.billingLastName.clear();
		this.billingLastName.sendKeys(lastName);
	}

	public void setBillingEmail(String email) {
		this.billingEmail.isDisplayed();
		this.billingEmail.clear();
		this.billingEmail.sendKeys(email);
	}

	public void setBillingPhone(String phone) {
		this.billingPhone.isDisplayed();
		this.billingPhone.clear();
		this.billingPhone.sendKeys(phone);
	}

	public void setBillingCountry(String country) {
		this.billingCountry.isDisplayed();
		this.billingCountry.clear();
		this.billingCountry.sendKeys(country);
	}

	public void setBillingAddress1(String adress1) {
		this.billingAddress1.isDisplayed();
		this.billingAddress1.clear();
		this.billingAddress1.sendKeys(adress1);
	}

	public void setBillingPostcode(String code) {
		this.billingPostcode.isDisplayed();
		this.billingPostcode.clear();
		this.billingPostcode.sendKeys(code);
	}

	public void setBillingCity(String city) {
		this.billingCity.isDisplayed();
		this.billingCity.clear();
		this.billingCity.sendKeys(city);
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
