package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage{
	WebDriver driver;
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
		
	}
	
	@Step("Enter to Firstname textbox with value is {0}")
	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
		
	}
	
	@Step("Enter to Lastname textbox with value is {0}")
	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
		
	}
	
	@Step("Select day with value is {0}")
	public void selectDayDropdown(String day) {
		waitForElementClickable(driver, UserRegisterPageUI.DAY_DROP_DOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.DAY_DROP_DOWN, day);
		
	}
	
	@Step("Select month with value is {0}")
	public void selectMonthDropdown(String month) {
		waitForElementClickable(driver, UserRegisterPageUI.MONTH_DROP_DOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.MONTH_DROP_DOWN, month);
		
	}

	public void selectYearDropdown(String year) {
		waitForElementClickable(driver, UserRegisterPageUI.YEAR_DROP_DOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.YEAR_DROP_DOWN, year);
		
	}
	
	@Step("Enter to Email textbox with value is {0}")
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
		
	}
	
	@Step("Enter to Company textbox with value is {0}")
	public void inputToCompanyTextbox(String companyName) {
		waitForElementVisible(driver, UserRegisterPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.COMPANY_TEXTBOX, companyName);
		
	}
	
	@Step("Enter to Password textbox with value is {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}
	
	@Step("Enter to ConfirmPassword textbox with value is {0}")
	public void inputToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
		
	}
	
	@Step("Click to Register button ")
	public void clickToRegisterButton() {
	waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
	clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
		
	}
	
	@Step("Verify register success message is displayed")
	public String getRegisterSuccessMessage() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
	}
	
	@Step("Click to Logout link ")
	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, UserRegisterPageUI.LOGIN_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGIN_LINK);
		//Cach 2. return new HomePageObject(driver);
		return PageGeneratorManager.getUserLoginPage(driver);
	}
	
	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.LASTNAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

}
