package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.UserHomePageUI;

public class UserHomePageObject extends BasePage{
	// Biến toàn cục
	WebDriver driver;
	
	//Ham khoi tao (constructor method)
	//Khi new Class này lên HomePageObject thì nó sẽ chạy đầu tiên
	// Ko kiểu trả về
	// Hàm khởi tạo bắt buộc cùng tên với class
	public UserHomePageObject(WebDriver driver) {
		// WebDriver driver: Biến cụ bộ của hàm
		this.driver = driver;
	}


	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.LOGOUT_LINK);
	}

	public UserCustomerInfoPO clickToMyAccountLink() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerInfoPage(driver);
		
	}


	public boolean isResterLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.REGISTER_LINK);
		return isElementDisplayed(driver, UserHomePageUI.REGISTER_LINK);
	}


	public boolean isLoginLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.LOGIN_LINK);
		return isElementDisplayed(driver, UserHomePageUI.LOGIN_LINK);
	}
	
	public boolean isResterLinkUndisplayed() {
		waitForElementInvisible(driver, UserHomePageUI.REGISTER_LINK);
		return isElementUndisplayed(driver, UserHomePageUI.REGISTER_LINK);
	}


	public boolean isLoginLinkUndisplayed() {
		waitForElementInvisible(driver, UserHomePageUI.LOGIN_LINK);
		return isElementUndisplayed(driver, UserHomePageUI.LOGIN_LINK);
	}


}