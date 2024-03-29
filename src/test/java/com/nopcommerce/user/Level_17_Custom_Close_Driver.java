package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_17_Custom_Close_Driver extends BaseTest{
	private WebDriver driver;
	private String firstName, emailAdress, lastName, validPassword;
	String day, month, year;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
 
		firstName = "Tran";
		lastName = "Tuyen";
		emailAdress = "tuyen" + randomNumber() + "@mail.vn";
		validPassword = "123456";
		
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstNameTextbox(firstName);
		
		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Register - Step 04: Enter to Email textbox with value is '" + emailAdress + "'");
		registerPage.inputToEmailTextbox(emailAdress);
		
		log.info("Register - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inputToPasswordTextbox(validPassword);
		
		log.info("Register - Step 06: Enter to Confirm Password textbox with value is '" + validPassword + "'");
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		log.info("Register - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 08: Verify register success messge is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		
		log.info("Register - Step 09: Click to Logint link");
		loginPage = registerPage.clickToLoginLink();
		
		log.info("Login - Step 01: Navigate to Login page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: Enter to Email textbox with value is '" + emailAdress + "'");
		loginPage.inputToEmailTextbox(emailAdress);
		
		log.info("Login - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inputToPasswordTextbox(validPassword);
		
		log.info("Login - Step 04: Click to 'Register' button");
		homePage = loginPage.clickToLoginButton();
		log.info("Login - Step 05: Verify 'My account' link is displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		
		log.info("Login - Step 06: Navigate to 'My account' page");
		customerInforPage = homePage.clickToMyAccountLink();
		
		log.info("Login - Step 07: Verify 'Customer Infor' page is displayed");
		Assert.assertFalse(customerInforPage.isCustomerInforDisplayed());
		
	}
	
	@Test
	public void User_01_Register_Login() {

	}
	
	@Test
	public void User_02_Login() {

	}
	

	@AfterTest (alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver();
	}

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
	
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	

}
