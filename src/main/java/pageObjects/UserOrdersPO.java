package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.UserLoginPageUI;
import pageUIs.UserMyProductReviewPageUI;
import pageUIs.UserOrdersPageUI;

public class UserOrdersPO extends BasePage{
	WebDriver driver;
	
	public UserOrdersPO(WebDriver driver) {
		this.driver = driver;
	}
}
