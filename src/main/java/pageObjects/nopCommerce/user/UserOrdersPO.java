package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserLoginPageUI;
import pageUIs.nopCommerce.user.UserMyProductReviewPageUI;
import pageUIs.nopCommerce.user.UserOrdersPageUI;

public class UserOrdersPO extends BasePage{
	WebDriver driver;
	
	public UserOrdersPO(WebDriver driver) {
		this.driver = driver;
	}
}
