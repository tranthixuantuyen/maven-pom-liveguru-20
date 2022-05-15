package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserAddressedPageUI;
import pageUIs.nopCommerce.user.UserLoginPageUI;

public class UserAddressesPageObject extends BasePage{
	WebDriver driver;
	
	public UserAddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
