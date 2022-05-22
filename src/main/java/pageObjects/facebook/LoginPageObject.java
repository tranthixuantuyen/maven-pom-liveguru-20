package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;
	public LoginPageObject (WebDriver driver) {
		this.driver = driver;
	}
	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		
	}
	public boolean isEmailAddressTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
	}
	public boolean isConfirmEmailAddressTextboxDisplayed() {
		return isElementDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}
	public void enterToEmailAddressTextboxDisplayed(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);	
	}
	public void closeIconAtRegisterForm() {
		waitForElementClickable(driver, LoginPageUI.CLOSE_ICON);
		clickToElement(driver, LoginPageUI.CLOSE_ICON);
	}
	public boolean isConfirmEmailAddressTextboxUndisplayed() {
		return isElementUndisplayed(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
	}

}
