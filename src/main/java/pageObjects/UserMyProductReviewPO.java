package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.UserLoginPageUI;
import pageUIs.UserMyProductReviewPageUI;

public class UserMyProductReviewPO extends BasePage{
	WebDriver driver;
	
	public UserMyProductReviewPO(WebDriver driver) {
		this.driver = driver;
	}
}
