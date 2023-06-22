package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import data.UserData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import java.util.Random;

public class Level_20_Manage_Data_Part_III extends BaseTest{
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		emailAdress = UserData.Register.EMAIL_ADDRESS + randomNumber() + "@fakemail.com";
	}
	
	@Test
	public void User_01_Register_Login() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRadioButtonByLabel(driver,"Female");
		
		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + UserData.Register.FIRST_NAME + "'");
		registerPage.inputTextboxByID(driver,"FirstName",UserData.Register.FIRST_NAME);
		
		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + UserData.Register.LAST_NAME + "'");
		registerPage.inputTextboxByID(driver,"LastName",UserData.Register.LAST_NAME);
		
		registerPage.selectToDropdownByName(driver,"DateOfBirthDay", UserData.Register.DATE);
		registerPage.selectToDropdownByName(driver,"DateOfBirthMonth", UserData.Register.MONTH);
		registerPage.selectToDropdownByName(driver,"DateOfBirthYear", UserData.Register.YEAR);
		
		log.info("Register - Step 04: Enter to Email textbox with value is '" + emailAdress + "'");
		registerPage.inputTextboxByID(driver,"Email",emailAdress);
		
		registerPage.clickToTextboxByLabel(driver,"Newsletter");
		
		log.info("Register - Step 05: Enter to Password textbox with value is '" + UserData.Register.PASSWORD + "'");
		registerPage.inputTextboxByID(driver,"Password",UserData.Register.PASSWORD);
		
		log.info("Register - Step 06: Enter to Confirm Password textbox with value is '" + UserData.Register.PASSWORD + "'");
		registerPage.inputTextboxByID(driver,"ConfirmPassword",UserData.Register.PASSWORD);
		
		log.info("Register - Step 07: Click to 'Register' button");
		registerPage.clickToButtonByText(driver,"Register");
		
		log.info("Register - Step 08: Verify register success messge is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		
	}
	
	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to Login page");
		loginPage = registerPage.clickToLoginLink();
		
		log.info("Login - Step 02: Enter to Email textbox with value is '" + emailAdress + "'");
		loginPage.inputTextboxByID(driver,"Email",emailAdress);
		
		log.info("Login - Step 03: Enter to Password textbox with value is '" + UserData.Register.PASSWORD + "'");
		loginPage.inputTextboxByID(driver,"Password",UserData.Register.PASSWORD);
		
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
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver,"FirstName"), UserData.Register.FIRST_NAME);
		
		log.info("My Account - Step 04: Verify 'Last Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver,"LastName"), UserData.Register.LAST_NAME);
		
		log.info("My Account - Step 05: Verify 'Email' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver,"Email"), emailAdress);
		
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}
	private WebDriver driver;
	private String emailAdress;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
	

}
