package bookShoop.selenium.core.section;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bookShoop.selenium.core.Section;

public class BankTransferSection extends Section{

	@FindBy(id = "payment_method_bacs")
    private WebElement directBankTransferPaymentRadioButton;
	
	@FindBy(id = "payment_method_cheque")
    private WebElement checkPaymentRadioButton;
	
	@FindBy(id = "payment_method_cod")
    private WebElement cashPaymentRadioButton;
	
	@FindBy(id = "payment_method_ppec_paypal")
    private WebElement payPalPaymentRadioButton;
	
	
	public BankTransferSection(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isBankTransferChecked() {
		this.directBankTransferPaymentRadioButton.isSelected();
		return true;
	}
	
}
