package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserAddressedPageUI;
import pageUIs.nopCommerce.user.UserLoginPageUI;

public class UserRewardPointPageObject extends BasePage{
	WebDriver driver;
	
	public UserRewardPointPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
