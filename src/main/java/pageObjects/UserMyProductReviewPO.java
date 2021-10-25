package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserLoginPageUI;
import pageUIs.UserMyProductReviewPageUI;

public class UserMyProductReviewPO extends AbstractPage{
	WebDriver driver;
	
	public UserMyProductReviewPO(WebDriver driver) {
		this.driver = driver;
	}
}
