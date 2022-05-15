package pageObjects.jQuery;

import java.awt.dnd.DropTargetListener;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	public HomePageObject (WebDriver driver) {
		this.driver = driver;
	}
	public void openPagingByPageNumber(String pageNumer) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumer);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumer);
		
		
	}
	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
		
		
	}
	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
	}
	public List<String> getValueEachRowAtAllPage(){
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.print("Total size= "+totalPage);
		
		List<String> allRowValuesAllPage = new ArrayList<String>();
		
		// Duyet qua tat ca cac page number
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));
			
			// Get text cua all row moi page dua vao ArrayList
			List<WebElement> allRowElementEachPage = getElements(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValuesAllPage.add(eachRow.getText());
			}
		}
		// In tat ca gia tri row cua tat ca cac page
		for (String value: allRowValuesAllPage) {
			System.out.println(value);
		}
		return allRowValuesAllPage;
		
	}

}
