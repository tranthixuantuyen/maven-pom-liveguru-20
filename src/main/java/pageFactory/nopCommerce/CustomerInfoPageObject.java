package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPageObject extends BasePageFactory{
	WebDriver driver;
	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="gender-male")
	WebElement genderMaleRadio;
	
	@FindBy(id="FirstName")
	WebElement firstNameTextbox;
	
	@FindBy(id="LastName")
	WebElement lastnameTextbox;
	
	
	@FindBy(id="Email")
	WebElement emailTextbox;
	
	@FindBy(id="Company")
	WebElement companyTextbox;
	


	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, firstNameTextbox);
		return getElementAttribute(driver, firstNameTextbox,"value");
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, lastnameTextbox);
		return getElementAttribute(driver, lastnameTextbox, "value");
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, emailTextbox);
		return getElementAttribute(driver, emailTextbox, "value");
	}

	public String getCompanyTextboxValue() {
		waitForElementVisible(driver, companyTextbox);
		return getElementAttribute(driver, companyTextbox, "value");
	}

}
