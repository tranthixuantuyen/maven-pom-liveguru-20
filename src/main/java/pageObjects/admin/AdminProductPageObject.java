package pageObjects.admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.admin.AdminProductPageUI;

public class AdminProductPageObject extends BasePage{
	WebDriver driver;
	
	public AdminProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void goToPageAtTableByIndex(String indexPage) {
		waitForElementClickable(driver, AdminProductPageUI.PAGING_AT_TABLE_BY_INDEX,indexPage);
		clickToElement(driver, AdminProductPageUI.PAGING_AT_TABLE_BY_INDEX,indexPage);
	}

	public boolean isPageActivedTableByIndex(String indexPage) {
		waitForElementVisible(driver, AdminProductPageUI.PAGING_AT_TABLE_ACTIVE_BY_INDEX,indexPage);
		return isElementDisplayed(driver, AdminProductPageUI.PAGING_AT_TABLE_ACTIVE_BY_INDEX,indexPage);
	}

	public void checkToSelectAllCheckbox() {
		waitForElementClickable(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		checkToCheckbox(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		
	}

	public void uncheckToSelectAllCheckbox() {
		waitForElementClickable(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		uncheckToCheckbox(driver, AdminProductPageUI.ALL_PRODUCT_CHECKBOX);
		
	}
	
	/*
	 * public boolean areProductCheckboxChecked() { boolean status = false;
	 * List<WebElement> allProductCheckboxes = getElements(driver,
	 * AdminProductPageUI.ALL_PRODUCT_CHECKBOX); for (WebElement productCheckbox :
	 * allProductCheckboxes) { if (productCheckbox.isSelected()) { return true; }
	 * return false;
	 * 
	 * }
	 * 
	 * }
	 */

}
