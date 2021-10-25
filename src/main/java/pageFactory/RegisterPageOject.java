package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageOject extends AbstractPage{
	WebDriver driver;
	public RegisterPageOject(WebDriver driver) {
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
	
	@FindBy(id="Password")
	WebElement passwordTextbox;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTextbox;
	
	@FindBy(id="register-button")
	WebElement registerButton;
	
	@FindBy(className="result")
	WebElement registerSuccessMessage;
	
	@FindBy(className="ico-logout")
	WebElement logoutLink;
	

	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);
		
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);
		
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastnameTextbox);
		sendkeyToElement(driver, lastnameTextbox, lastName);
		
	}

	public void selectDayDropdown(String day) {
		waitForElementClickable(driver, dayDropdown) ;
		selectItemInDropdown(driver, dayDropdown , day);
		
	}

	public void selectMonthDropdown(String month) {
		waitForElementClickable(driver, monthDropdown);
		selectItemInDropdown(driver, monthDropdown, month);
		
	}

	public void selectYearDropdown(String year) {
		waitForElementClickable(driver, yearDropdown);
		selectItemInDropdown(driver, yearDropdown, year);
		
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
		
	}

	public void inputToCompanyTextbox(String companyName) {
		waitForElementVisible(driver, companyTextbox);
		sendkeyToElement(driver, companyTextbox, companyName);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
		
	}

	public void inputToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, password);
		
	}

	public void clickToRegisterButton() {
	waitForElementClickable(driver, registerButton);
	clickToElement(driver, registerButton);
		
	}
	public String getRegisterSuccessMessage() {
		waitForElementClickable(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
		
	}

}
