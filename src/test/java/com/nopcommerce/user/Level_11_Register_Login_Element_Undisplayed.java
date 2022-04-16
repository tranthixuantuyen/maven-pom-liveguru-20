package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserAddressesPageObject;
import pageObjects.user.UserCustomerInforPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserMyProductReviewPageObject;
import pageObjects.user.UserOrdersPO;
import pageObjects.user.UserRegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Level_11_Register_Login_Element_Undisplayed extends AbstractTest{

	WebDriver driver;
	
	String firstName, email, lastName, companyName, password;
	String day, month, year;
	
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInforPageObject customerInforPage;
	UserAddressesPageObject addressesPage;
	UserOrdersPO orderPage;
	UserMyProductReviewPageObject myProductPage;
	
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
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		//Verify Register link displayed
		Assert.assertTrue(homePage.isResterLinkDisplayed());
		
		// Verify Login link displayed
		Assert.assertTrue(homePage.isLoginLinkDisplayed());
		
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
		
		//Verify My Account link displayed
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		//Verify My Logout link displayed
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
		
		//Verify Register link undisplayed
		Assert.assertTrue(homePage.isResterLinkUndisplayed());
		
		//Verify Login link undisplayed
		Assert.assertTrue(homePage.isLoginLinkUndisplayed());
	}


	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
