package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.UserAddressesPO;
import pageObjects.UserCustomerInfoPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserMyProductReviewPO;
import pageObjects.UserOrdersPO;
import pageObjects.PageGeneratorManager;
import pageObjects.UserRegisterPO;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Level_11_Register_Login_Element_Undisplayed extends AbstractTest{

	WebDriver driver;
	
	String firstName, email, lastName, companyName, password;
	String day, month, year;
	
	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
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