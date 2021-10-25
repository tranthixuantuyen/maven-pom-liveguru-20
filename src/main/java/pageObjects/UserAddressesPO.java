package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserAddressedPageUI;
import pageUIs.UserLoginPageUI;

public class UserAddressesPO extends AbstractPage{
	WebDriver driver;
	
	public UserAddressesPO(WebDriver driver) {
		this.driver = driver;
	}
}
