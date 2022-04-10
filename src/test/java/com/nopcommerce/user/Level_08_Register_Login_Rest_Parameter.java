package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.UserAddressesPO;
import pageObjects.UserCustomerInfoPO;
import pageObjects.UserHomePageObject;
import pageObjects.UserLoginPageObject;
import pageObjects.UserMyProductReviewPO;
import pageObjects.UserOrdersPO;
import pageObjects.PageGeneratorManager;
import pageObjects.UserRegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Level_08_Register_Login_Rest_Parameter extends AbstractTest{

	WebDriver driver;
	
	String firstName, email, lastName, companyName, password;
	String day, month, year;
	
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPO customerInforPage;
	UserAddressesPO addressesPage;
	UserOrdersPO orderPage;
	UserMyProductReviewPO myProductPage;
	
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);

		firstName = "Tran";
		lastName = "Tuyen";
		companyName = "Demo";
		email = "tuyen" + randomNumber() + "@hotmail.com";
		password = "123456";
		day = "12";
		month = "August";
		year = "1992";
	}

	@Test
	public void TC_01_RegisterToSystem() {
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		registerPage = homePage.clickToRegisterLink();	
		
		registerPage.clickToGenderMaleRadioButton();
		
		registerPage.inputToFirstNameTextbox(firstName);
		
		registerPage.inputToLastNameTextbox(lastName);
		
		registerPage.selectDayDropdown(day);
		
		registerPage.selectMonthDropdown(month);
		
		registerPage.selectYearDropdown(year);
		
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToCompanyTextbox(companyName);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_02_LoginToSystem() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
	public void TC_03_ViewMyAccount() {
		customerInforPage = homePage.clickToMyAccountLink();
		
		Assert.assertTrue(customerInforPage.isGenderMaleRadioButtonSelected());
		Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(),firstName);
		Assert.assertEquals(customerInforPage.getLastNameTextboxValue(),lastName);
		Assert.assertEquals(customerInforPage.getSelectedTextDayDropDown(),day);
		Assert.assertEquals(customerInforPage.getSelectedTextMonthDropDown(),month);
		Assert.assertEquals(customerInforPage.getSelectedTextYearDropDown(),year);
		Assert.assertEquals(customerInforPage.getEmailTextboxValue(),email);
		Assert.assertEquals(customerInforPage.getCompanyTextboxValue(),companyName);
	}
	
	@Test
	// 10-15 PAGES
	public void TC_04_Switch_Page_Solution_01() {

		addressesPage = (UserAddressesPO) customerInforPage.openLinkByPageName(driver, "Addresses");
		
		customerInforPage = (UserCustomerInfoPO) addressesPage.openLinkByPageName(driver,"Customer info");
		
		myProductPage = (UserMyProductReviewPO) addressesPage.openLinkByPageName(driver,"My product reviews");
		
		orderPage = (UserOrdersPO) myProductPage.openLinkByPageName(driver,"Orders");
			
		addressesPage = (UserAddressesPO) orderPage.openLinkByPageName(driver, "Addresses");
		
		customerInforPage = (UserCustomerInfoPO) addressesPage.openLinkByPageName(driver,"Customer info");
	}
	
	@Test
	// >10 PAGES
	public void TC_05_Switch_Page_Solution_02() {
		
		// Customer -> Addresses 
		customerInforPage.openLinkWithPageName(driver, "Addresses");
		addressesPage = PageGeneratorManager.getAddressesPage(driver);
		
		addressesPage.openLinkWithPageName(driver, "Customer info");
		customerInforPage = PageGeneratorManager.getCustomerInfoPage(driver);
		
		customerInforPage.openLinkWithPageName(driver, "My product reviews");
		myProductPage = PageGeneratorManager.getMyProductReviewPage(driver);
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
