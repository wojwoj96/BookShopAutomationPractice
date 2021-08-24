package bookShoop.selenium.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ShoppingCardPage extends Page {

	@FindBy(css = "#page-34 > div > div.woocommerce > form > table > tbody > tr.cart_item > td.product-name > a")
	private List<WebElement> productNameInTheBasketCss;

	@FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[3]/a")
	private WebElement productNameInTheBasketXpath;

	@FindBy(css = "#page-34 > div > div.woocommerce > form > table > tbody > tr:nth-child(2) > td > input.button")
	private WebElement updateButtonXpath;

	@FindBy(css = "#page-34 > div > div.woocommerce > div > div > div > a")
	private WebElement proceedToCheckoutButtonXpath;

	@FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[1]/td/span/")
	private WebElement subtotalPrice;

	@FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[2]/td/span")
	private WebElement taxPrice;

	@FindBy(css = "#page-34 > div > div.woocommerce > div > div > table > tbody")
	private WebElement totalPrice;

	@FindBy(css = "#page-34 > div > div.woocommerce > div > div > div > a")
	private List<WebElement> shoppingCardSummaryTable;

	private WebDriver driver;

	public ShoppingCardPage(WebDriver driver) {
		this.driver = driver;
		// UiBot.waitForPageLoaded();
		// Initialise Elements
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);

	}

	// To check if page is opened and has added book.
	public String containBasketProductRightTitle() {
		return productNameInTheBasketXpath.getText().toString();
	}

	public boolean isUpdateBasketAvailable() {
		return this.updateButtonXpath.isEnabled();
	}

	public CheckOrderPage proceedToCheckout() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// UiBot.waitForPageLoaded();
		this.proceedToCheckoutButtonXpath.click();
		return new CheckOrderPage(driver);
	}

	public WebElement getSubtotalPrice() {
		return subtotalPrice;
	}

	public WebElement getTaxPrice() {
		return taxPrice;
	}

	public WebElement getTotalPrice() {
		return totalPrice;
	}

	public List<String> getPricesValueFromTheShoppingCardTable() {

		return Arrays.asList(//
				subtotalPrice.getText(), //
				taxPrice.getText(), //
				totalPrice.getText()); //
	}

	public List<WebElement> getSelectedPriceValueFromTheShoppingCardTable(int index) {
		return (List<WebElement>) shoppingCardSummaryTable.get(index);
	}
}
