package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserLoginPageUI;
import pageUIs.user.UserMyProductReviewPageUI;

public class UserMyProductReviewPageObject extends BasePage{
	WebDriver driver;
	
	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
