package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage {
	WebDriver driver;
	
	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminProductPO openProductPage() {
		
	waitForElementClickable(driver, AdminDashboardPageUI.CATALOG_LINK_SIDEBAR);
	clickToElement(driver, AdminDashboardPageUI.CATALOG_LINK_SIDEBAR);
	
	waitForElementClickable(driver, AdminDashboardPageUI.PRODUCT_LINK_AT_SIDEBAR);
	clickToElement(driver, AdminDashboardPageUI.PRODUCT_LINK_AT_SIDEBAR);
	
	return PageGeneratorManager.getAdminProductPage(driver);
		
	}

}
