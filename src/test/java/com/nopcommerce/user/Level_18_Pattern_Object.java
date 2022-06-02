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

public class Level_18_Pattern_Object extends BaseTest{
	private WebDriver driver;
	private String firstName, emailAdress, lastName, validPassword;
	String date, month, year;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
 
		firstName = "Tran";
		lastName = "Tuyen";
		emailAdress = "tuyen" + randomNumber() + "@mail.vn";
		validPassword = "123456";
		date = "10";
		month = "November";
		year = "1930";
		
	}
	
	@Test
	public void User_01_Register_Login() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRadioButtonByLabel(driver,"Female");
		
		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputTextboxByID(driver,"FirstName",firstName);
		
		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputTextboxByID(driver,"LastName",lastName);
		
		registerPage.selectToDropdownByName(driver,"DateOfBirthDay", date);
		registerPage.selectToDropdownByName(driver,"DateOfBirthMonth", month);
		registerPage.selectToDropdownByName(driver,"DateOfBirthYear", year);
		
		log.info("Register - Step 04: Enter to Email textbox with value is '" + emailAdress + "'");
		registerPage.inputTextboxByID(driver,"Email",emailAdress);
		
		registerPage.clickToTextboxByLabel(driver,"Newsletter");
		
		log.info("Register - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inputTextboxByID(driver,"Password",validPassword);
		
		log.info("Register - Step 06: Enter to Confirm Password textbox with value is '" + validPassword + "'");
		registerPage.inputTextboxByID(driver,"ConfirmPassword",validPassword);
		
		log.info("Register - Step 07: Click to 'Register' button");
		registerPage.clickToButtonByText(driver,"Register");
		
		log.info("Register - Step 08: Verify register success messge is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		
	}
	
	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to Login page");
		homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: Enter to Email textbox with value is '" + emailAdress + "'");
		loginPage.inputTextboxByID(driver,"Email",emailAdress);
		
		log.info("Login - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inputTextboxByID(driver,"Password",validPassword);
		
		log.info("Login - Step 04: Click to 'Register' button");
		loginPage.clickToButtonByText(driver,"Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Login - Step 05: Verify 'My account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		
		log.info("Login - Step 06: Navigate to 'My account' page");
		customerInforPage = homePage.clickToMyAccountLink();
		
		log.info("Login - Step 07: Verify 'Customer Infor' page is displayed");
		verifyTrue(customerInforPage.isCustomerInforDisplayed());

	}
	
	@Test
	public void User_03_My_Account() {
		log.info("My Account - Step 01: Navigate to 'My Account' page");
		customerInforPage = homePage.clickToMyAccountLink();
		
		log.info("My Account - Step 02: Verify 'Customer Infor' page is displayed");
		Assert.assertTrue(customerInforPage.isCustomerInforDisplayed());
		
		log.info("My Account - Step 03: Verify 'Firt Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver,"FirstName"), firstName);
		
		log.info("My Account - Step 04: Verify 'Last Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver,"LastName"), lastName);
		
		log.info("My Account - Step 05: Verify 'Email' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver,"Email"), emailAdress);
		
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
