package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserLoginPageUI;
import pageUIs.user.UserMyProductReviewPageUI;
import pageUIs.user.UserOrdersPageUI;

public class UserOrdersPO extends BasePage{
	WebDriver driver;
	
	public UserOrdersPO(WebDriver driver) {
		this.driver = driver;
	}
}
