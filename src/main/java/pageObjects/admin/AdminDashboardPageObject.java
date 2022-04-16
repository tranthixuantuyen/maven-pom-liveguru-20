package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
	WebDriver driver;
	
	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	

	public AdminProductPageObject openProductPage() {
		
	waitForElementClickable(driver, AdminDashboardPageUI.CATALOG_LINK_SIDEBAR);
	clickToElement(driver, AdminDashboardPageUI.CATALOG_LINK_SIDEBAR);
	
	waitForElementClickable(driver, AdminDashboardPageUI.PRODUCT_LINK_AT_SIDEBAR);
	clickToElement(driver, AdminDashboardPageUI.PRODUCT_LINK_AT_SIDEBAR);
	
	return PageGeneratorManager.getAdminProductPage(driver);
		
	}


	public boolean isDashboardHeaderDisplayed() {
		waitForElementVisible(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
	}

}
