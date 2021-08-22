package bookShoop.selenium.core;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends Page{

	@FindBy(css = "#content > ul > li")
    private List<WebElement> books;
	
	@FindBy(xpath = "*[@id=\"content\"]/ul/li[1]/a[2]")
    private WebElement firstAddButton;
		
	
	public ShopPage(boolean init) {
		super(init);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void open(Object... arguments) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assertIsOpen(Object... arguments) throws AssertionError {
		// TODO Auto-generated method stub
		
	}

	public void seeBook(final int index) {
		books.get(index).click();
		
	}
	
	public void addBookToTheShoppingCard() {
		this.firstAddButton.click();
	}
		
	
}
