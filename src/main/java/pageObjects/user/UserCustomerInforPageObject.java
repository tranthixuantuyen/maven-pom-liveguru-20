package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserCustomerInforPageUI;

public class UserCustomerInforPageObject extends BasePage{
	WebDriver driver;
	public UserCustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}
	

	public boolean isGenderMaleRadioButtonSelected() {
		waitForElementVisible(driver, UserCustomerInforPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, UserCustomerInforPageUI.GENDER_MALE_RADIO);
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getSelectedTextDayDropDown() {
		waitForElementVisible(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
	}

	public String getSelectedTextMonthDropDown() {
		waitForElementVisible(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
	}

	public String getSelectedTextYearDropDown() {
		waitForElementVisible(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyTextboxValue() {
		waitForElementVisible(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX, "value");
	}


	public boolean isCustomerInforDisplayed() {
		waitForElementVisible(driver, UserCustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, UserCustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}


}
