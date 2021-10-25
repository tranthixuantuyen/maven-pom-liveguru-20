package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject extends AbstractPage{
	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	//Định nghĩa element
	@FindBy(xpath="//input[@id='Email']")
	WebElement emailTextbox;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement loginButton;
	
	
	// Actions
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);	
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);	
	}

}
