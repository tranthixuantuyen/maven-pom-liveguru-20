package com.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_15_ExtentV5_Screenshot extends BaseTest{
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
		
	}
	
	@Test
	public void User_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system with valid Email and Password");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(Status.INFO,"Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstNameTextbox(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToLastNameTextbox(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register - Step 04: Enter to Email textbox with value is '" + emailAdress + "'");
		registerPage.inputToEmailTextbox(emailAdress);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inputToPasswordTextbox(validPassword);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register - Step 06: Enter to Confirm Password textbox with value is '" + validPassword + "'");
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO,"Register - Step 08: Verify register success messge is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		
	}
	
	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_02_Login");
		ExtentTestManager.getTest().log(Status.INFO,"Login - Step 01: Navigate to Login page");
		loginPage = registerPage.clickToLoginLink();
		
		ExtentTestManager.getTest().log(Status.INFO,"Login - Step 02: Enter to Email textbox with value is '" + emailAdress + "'");
		loginPage.inputToEmailTextbox(emailAdress);
		
		ExtentTestManager.getTest().log(Status.INFO,"Login - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inputToPasswordTextbox(validPassword);
		
		ExtentTestManager.getTest().log(Status.INFO,"Login - Step 04: Click to 'Register' button");
		homePage = loginPage.clickToLoginButton();
	//	Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		ExtentTestManager.getTest().log(Status.INFO,"Login - Step 05: Verify 'My account' link is displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO,"Login - Step 06: Navigate to 'My account' page");
		customerInforPage = homePage.clickToMyAccountLink();
	//	Assert.assertTrue(customerInforPage.isCustomerInforDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO,"Login - Step 07: Verify 'Customer Infor' page is displayed");
		Assert.assertFalse(customerInforPage.isCustomerInforDisplayed());

	}
	

	@AfterTest
	public void afterTest() {
		driver.quit();
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
