package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserOrdersPO;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import utilities.FakerConfig;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Level_18_Register_Login_Fake_Data extends AbstractTest{

	WebDriver driver;
	FakerConfig faker;
	
	String firstName, email, lastName, companyName, password;
	String day, month, year;
	
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInforPageObject customerInforPage;
	UserAddressesPageObject addressesPage;
	UserOrdersPO orderPage;
	UserMyProductReviewPageObject myProductPage;
	
	@Parameters({"browser", "url"})
	@BeforeTest
	public void beforeTest(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		faker = FakerConfig.getData();

		firstName = faker.getFirstName();
		lastName = faker.getLastName();
		companyName = faker.getCompanyName();
		email = faker.getEmail();
		password = faker.getPassword();
		day = "12";
		month = "August";
		year = "1992";
	}

	@Test
	public void TC_01_RegisterToSystem() {
		
		log.info("Register - Step 01: Open Home Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Register - Step 02: Verify Register link displayed");
		Assert.assertTrue(homePage.isResterLinkDisplayed());
		
		log.info("Register - Step 03: Verify Login link displayed");
		Assert.assertTrue(homePage.isLoginLinkDisplayed());
		
		log.info("Register - Step 04: Click to Register link at HomePage");
		registerPage = homePage.clickToRegisterLink();	
		
		log.info("Register - Step 05:Click to gender male button");
		registerPage.clickToGenderMaleRadioButton();
		
		log.info("Register - Step 06:input value to firstname with value" + firstName);
		registerPage.inputToFirstNameTextbox(firstName);
		
		log.info("Register - Step 07:input value to lastName with value" + lastName);
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Register - Step 08:select day dropdown");
		registerPage.selectDayDropdown(day);
		
		log.info("Register - Step 09:select month dropdown");
		registerPage.selectMonthDropdown(month);
		
		log.info("Register - Step 10:select year dropdown");
		registerPage.selectYearDropdown(year);
		
		log.info("Register - Step 11: input email");
		registerPage.inputToEmailTextbox(email);
		
		log.info("Register - Step 12:input company");
		registerPage.inputToCompanyTextbox(companyName);
		
		log.info("Register - Step 13:input password textbox with value");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Register - Step 14:Click to register button at register page");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 15: Verify success mesage displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("Register - Step 16: CLick to logout link");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_02_LoginToSystem() {
		
		log.info("Register - Step 01: CLick to login link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Register - Step 02: input email");
		loginPage.inputToEmailTextbox(email);
		
		log.info("Register - Step 03: input password");
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Register - Step 04: click login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Register - Step 05: Verify My Account link displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		log.info("Register - Step 06: Verify My Logout link displayed");
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
		
		log.info("Register - Step 07: Verify Register link undisplayed");
		Assert.assertTrue(homePage.isResterLinkUndisplayed());
		
		log.info("Register - Step 08: Verify Login link undisplayed");
		Assert.assertTrue(homePage.isLoginLinkUndisplayed());
	}


	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
