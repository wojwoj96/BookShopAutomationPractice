package testpackage;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class MavenTest1 {
	  
	public String baseUrl = "http://practice.automationtesting.in/";  
	String driverPath = "C:\\BookShopAutomationPractice\\BookShopAutomationPractice\\chromedriver_92.0.4515.107.exe";  
	
	public WebDriver driver ;   
	
	@BeforeTest  
	public void beforeTest() {    
	System.out.println("before test");  
	}     
	
	@Test             
	public void test() {      
	// set the system property for Chrome driver      
	System.setProperty("webdriver.chrome.driver", driverPath);  
	// Create driver object for CHROME browser  
	driver = new ChromeDriver();  
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
	driver.manage().window().maximize();  
	driver.get(baseUrl);  
	// get the current URL of the page  
	String URL= driver.getCurrentUrl();  
	System.out.print(URL);  
	//get the title of the page  
	String title = driver.getTitle();                  
	System.out.println(title); 
	driver.close();
	}     
	
	@AfterTest  
	public void afterTest() {  
	driver.quit(); 
	
	System.out.println("after test");  
	}         
}
