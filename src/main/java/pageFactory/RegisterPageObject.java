package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageUIs.UserRegisterPageUI;

public class RegisterPageObject extends BasePageFactory{
	WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="FirstName")
	WebElement firstNameTextbox;
	
	@FindBy(id="FirstName-error")
	WebElement firstNameErrorMessage;
	
	@FindBy(id="LastName")
	WebElement lastnameTextbox;
	
	@FindBy(id="LastName-error")
	WebElement lastnameErrorMessage;
	
	@FindBy(id="Email")
	WebElement emailTextbox;
	
	@FindBy(xpath="//div[contains(@class,'message-error')]//li")
	WebElement existingEmailErrorMessage;
	
	@FindBy(id="Email-error")
	WebElement emailErrorMessage;
	
	@FindBy(id="Password")
	WebElement passwordTextbox;
	
	@FindBy(id="Password-error")
	WebElement passwordErrorMessage;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTextbox;
	
	@FindBy(id="ConfirmPassword-error")
	WebElement confirmPasswordErrorMessage;
	
	@FindBy(id="register-button")
	WebElement registerButton;
	
	@FindBy(className="result")
	WebElement registerSuccessMessage;
	
	@FindBy(className="ico-logout")
	WebElement logoutLink;

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);
		
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastnameTextbox);
		sendkeyToElement(driver, lastnameTextbox, lastName);
		
	}


	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
		
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
	
	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, lastnameErrorMessage);
		return getElementText(driver, lastnameErrorMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getElementText(driver, confirmPasswordErrorMessage);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, existingEmailErrorMessage);
		return getElementText(driver, existingEmailErrorMessage);
	}

}
