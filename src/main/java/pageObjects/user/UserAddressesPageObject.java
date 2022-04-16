package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserAddressedPageUI;
import pageUIs.user.UserLoginPageUI;

public class UserAddressesPageObject extends BasePage{
	WebDriver driver;
	
	public UserAddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
