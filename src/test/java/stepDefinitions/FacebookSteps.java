package stepDefinitions;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookSteps {
	WebDriver driver;
	
	@Before 
	public void openFacebookApplication() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("^Input to Username textbox$")
	public void inputToUsernameTextbox() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("0977108233");

	}

	@When("^Input to Password testbox$")
	public void inputToPasswordTestbox() {
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys("nguyenchicuong");

	}

	@When("^Input to Username textbox with \"([^\"]*)\"$")
	
	public void inputToUsernameTextboxWith(String email) {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
	}
	
	@When("^Input to Password textbox with \"([^\"]*)\"$")
	public void inputToPasswordTextboxWith(String password) {
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(password);
	}
	

	@When("^Input to Username textbox with ([^\"]*)$")
	public void inputToUsernameTextbox(String email) {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
	}

	@When("^Input to Password testbox with ([^\"]*)$")
	public void inputToPasswordTestbox(String password) {
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(password);
	}

	@When("^Input to Username with \"([^\"]*)\" and Password with \"([^\"]*)\"$")
	public void inputToUsernameWithAndPasswordWith(String email, String password) {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);

		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(password);
	}
	
	@When("^Input to Username and Password$")
	public void inputToUsernameAndPassword(DataTable table) {
	    //  Truyen 1 gia tri	
		//	driver.findElement(By.xpath("//input[@name='name']")).sendKeys(customer.get(0).get("Name"));
		/*
		 * List<Map<String, String>> customer = table.asMaps(String.class,
		 * String.class);
		 * 
		 * driver.findElement(By.id("email")).clear();
		 * driver.findElement(By.id("email")).sendKeys(customer.get(0).get("Name"));
		 * 
		 * driver.findElement(By.id("pass")).clear();
		 * driver.findElement(By.id("pass")).sendKeys(customer.get(0).get("Pass"));
		 */
		// Lay het tat ca
		for (Map<String, String> loginInfor : table.asMaps(String.class, String.class)) {
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(loginInfor.get("Name"));
			
			driver.findElement(By.id("pass")).clear();
			driver.findElement(By.id("pass")).sendKeys(loginInfor.get("Pass"));
		}
		
		}

	
	@When("^Click to Submit button$")
	public void clickToSubmitButton() {
		driver.findElement(By.name("login")).click();
		
	}

	@After
	public void closeApplication() {
		driver.quit();
	}

}
