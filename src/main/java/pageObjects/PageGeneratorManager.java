package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static UserLoginPageObject getLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	public static UserHomePageObject getHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	public static UserRegisterPageObject getRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	public static UserCustomerInfoPO getCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPO(driver);
	}
	public static UserAddressesPO getAddressesPage(WebDriver driver) {
		return new UserAddressesPO(driver);
	}
	public static UserOrdersPO getOrdersPage(WebDriver driver) {
		return new UserOrdersPO(driver);
	}
	public static UserMyProductReviewPO getMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPO(driver);
	}
	
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}
	
	public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPO(driver);
	}
	
	public static AdminProductPO getAdminProductPage(WebDriver driver) {
		return new AdminProductPO(driver);
	}

}
