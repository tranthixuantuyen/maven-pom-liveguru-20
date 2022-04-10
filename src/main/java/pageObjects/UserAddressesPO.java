package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.UserAddressedPageUI;
import pageUIs.UserLoginPageUI;

public class UserAddressesPO extends BasePage{
	WebDriver driver;
	
	public UserAddressesPO(WebDriver driver) {
		this.driver = driver;
	}
}
