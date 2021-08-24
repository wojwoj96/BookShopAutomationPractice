package testpackage;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

import bookShoop.selenium.core.CheckOrderPage;
import bookShoop.selenium.core.HomePage;
import bookShoop.selenium.core.OrderConfirmationPage;
import bookShoop.selenium.core.ShoppingCardPage;
import bookShop.selenium.integration.integration.AssertionHelper;
import bookShop.selenium.integration.integration.UiBot;
import bookShop.selenium.integration.rules.CollectorRules;

public class TestAddOneBookToCardWithoutCouponAndCheckRequiredFieldsAndMessage extends CollectorRules {

	WebDriver driver;

	@Before
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@After
	public void close() {
		driver.close();
	}

	@Test
	public void testAddOneBookToCardWithoutCouponAndCheckRequiredFieldsAndMessage() {

		String entryUrl = "http://practice.automationtesting.in/";

		HomePage home = new HomePage(driver) {
		};

		Assert.assertEquals(entryUrl, driver.getCurrentUrl());

		home.addBookToBasket();

		ShoppingCardPage shoppingCardPage = home.viewShoppingCard();

		// Checking if shopping card basket contains the right product.

		Assert.assertEquals(shoppingCardPage.containBasketProductRightTitle(), "Selenium Ruby");

		// Checking if the "update button" is available without basket modification.
		Assertions.assertThat(shoppingCardPage.isUpdateBasketAvailable());

		// Going on the next step.
		CheckOrderPage checkOrderPage = shoppingCardPage.proceedToCheckout();

		UiBot.waitUntilPageWillBeReady();

		// Validating required fields.

		checkOrderPage.placeOrder();

		UiBot.waitUntilPageWillBeReady();

		/*
		 * Simply assert using Junit library
		 * 
		 * Assert.assertEquals(Arrays.asList(//
		 * "Billing First Name is a required field.",//
		 * "Billing Last Name is a required field.",//
		 * "Billing Email Address is a required field.",//
		 * "Billing Phone is a required field.",//
		 * "Billing Address is a required field.",//
		 * "Billing Town / City is a required field.",//
		 * "Billing Postcode / ZIP is a required field."),
		 * checkOrderPage.getRequiredFieldList());
		 */

		// Helping class to better manage the potentially assertion required in the
		// project.
		AssertionHelper.assertValues(Arrays.asList(//
				"Billing First Name is a required field.", //
				"Billing Last Name is a required field.", //
				"Billing Email Address is a required field.", //
				"Billing Phone is a required field.", //
				"Billing Address is a required field.", //
				"Billing Town / City is a required field.", //
				"Billing Postcode / ZIP is a required field."), checkOrderPage.getRequiredFieldList());

		// Validating potentially sensitive fields like email or phone.

		checkOrderPage.setBillingFirstName("Matii");
		checkOrderPage.setBillingLastName("Smith");
		checkOrderPage.setBillingEmail("matismith@gmail");
		checkOrderPage.setBillingPhone("a");
		checkOrderPage.setBillingAddress1("a");
		checkOrderPage.setBillingPostcode("22222");
		checkOrderPage.setBillingCity("wawa");

		checkOrderPage.placeOrder();

		UiBot.waitUntilPageWillBeReady();

		AssertionHelper.assertValues(Arrays.asList(//
				"Email Address is not a valid email address.", //
				"Phone is not a valid phone number."), checkOrderPage.getRequiredFieldList());

		// Shopping without an account. Checking if the checkbox "CreateAccount"is
		// available and not checked

		// Assertions.assertThat(checkOrderPage.isCheckboxSelected().isEmpty());
		Assertions.assertThat(checkOrderPage.isCheckboxCreateAccountAktiv()).isTrue();
		Assertions.assertThat(checkOrderPage.isCheckboxCreateAccountSelected()).isFalse();

		// Payment method throw Direct Bank Transfer. Checking this option is checked.

		Assertions.assertThat(checkOrderPage.isRadiobuttonDirectBankTransferAktiv()).isTrue();
		Assertions.assertThat(checkOrderPage.isRadiobuttonDirectBankTransferSelected()).isTrue();

		
		// Checking payment method information message.
		Assert.assertEquals(
				"Make your payment directly into our bank account. Please use your Order ID as the payment reference. Your order won’t be shipped until the funds have cleared in our account.", //
				checkOrderPage.getDirectBankTransferText());

		// Checking total order ammount.

		// Good data filling the fields
		checkOrderPage.setBillingFirstName("Matii");
		checkOrderPage.setBillingLastName("Smith");
		checkOrderPage.setBillingEmail("matismith@gmail.com");
		checkOrderPage.setBillingPhone("111111111");
		checkOrderPage.setBillingAddress1("Av.23 de Maio");
		checkOrderPage.setBillingPostcode("22222");
		checkOrderPage.setBillingCity("Sao Paulo");

		UiBot.waitUntilPageWillBeReady();

		// Going on the next step.
		OrderConfirmationPage orderConfirmationPage = checkOrderPage.placeOrder();

		UiBot.waitUntilPageWillBeReady();

		Assert.assertEquals("Thank you. Your order has been received.", orderConfirmationPage.getconfirmationText());

		// Checking order details: subtotal, roaming tax, payment method, total price.

	}

}
