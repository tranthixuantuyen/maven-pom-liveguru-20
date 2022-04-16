package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserAddressedPageUI;
import pageUIs.user.UserLoginPageUI;

public class UserRewardPointPageObject extends BasePage{
	WebDriver driver;
	
	public UserRewardPointPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
