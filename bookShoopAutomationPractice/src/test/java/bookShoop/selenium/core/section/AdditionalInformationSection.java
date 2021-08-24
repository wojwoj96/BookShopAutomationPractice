package bookShoop.selenium.core.section;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bookShoop.selenium.core.Section;

public class AdditionalInformationSection extends Section{

	@FindBy(id = "order_comments")
    private WebElement orderComments;
	
	
	public AdditionalInformationSection(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

}
