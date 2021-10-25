package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPageObject extends AbstractPage{
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
	
	@FindBy(xpath="//select[@name='DateOfBirthDay']")
	WebElement dayDropdown;
	
	@FindBy(xpath="//select[@name='DateOfBirthMonth']")
	WebElement monthDropdown;
	
	@FindBy(xpath="//select[@name='DateOfBirthYear']")
	WebElement yearDropdown;
	
	@FindBy(id="Email")
	WebElement emailTextbox;
	
	@FindBy(id="Company")
	WebElement companyTextbox;
	
	public boolean isGenderMaleRadioButtonSelected() {
		waitForElementVisible(driver, genderMaleRadio);
		return isElementSelected(driver, genderMaleRadio);
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, firstNameTextbox);
		return getElementAttribute(driver, firstNameTextbox,"value");
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, lastnameTextbox);
		return getElementAttribute(driver, lastnameTextbox, "value");
	}

	public String getSelectedTextDayDropDown() {
		waitForElementVisible(driver, dayDropdown);
		return getFirstSelectedTextInDropdown(driver, dayDropdown);
	}

	public String getSelectedTextMonthDropDown() {
		waitForElementVisible(driver, monthDropdown);
		return getFirstSelectedTextInDropdown(driver, monthDropdown);
	}

	public String getSelectedTextYearDropDown() {
		waitForElementVisible(driver, yearDropdown);
		return getFirstSelectedTextInDropdown(driver, yearDropdown);
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
