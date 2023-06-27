package com.nopcommerce.user;

import com.nopcommerce.data.UserDataMapper;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.aeonbits.owner.ConfigFactory;
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
import utilities.Environment;

import java.util.Random;

public class Level_21_Multiple_Enviromment_Owner extends BaseTest{
	Environment environment;
	@Parameters({"browser","enviroment"})
	@BeforeClass
	public void beforeClass(String browserName, String enviromentName) {
		ConfigFactory.setProperty("env",enviromentName);
		environment = ConfigFactory.create(Environment.class);

		System.out.println( environment.appUrl());
		System.out.println( environment.appUserName());

		driver = getBrowserDriver(browserName, environment.appUrl());


		homePage = PageGeneratorManager.getUserHomePage(driver);
		userData = UserDataMapper.getUserData();
		emailAdress = userData.getEmailAddress() + randomNumber() + "@fakemail.com";
	}
	
	@Test
	public void User_01_Register_Login() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRadioButtonByLabel(driver,"Female");
		
		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + userData.getFirstName() + "'");
		registerPage.inputTextboxByID(driver,"FirstName",userData.getFirstName());
		
		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + userData.getLastName() + "'");
		registerPage.inputTextboxByID(driver,"LastName",userData.getLastName());
		
		registerPage.selectToDropdownByName(driver,"DateOfBirthDay", userData.getDate());
		registerPage.selectToDropdownByName(driver,"DateOfBirthMonth", userData.getMonth());
		registerPage.selectToDropdownByName(driver,"DateOfBirthYear", userData.getYear());
		
		log.info("Register - Step 04: Enter to Email textbox with value is '" + emailAdress + "'");
		registerPage.inputTextboxByID(driver,"Email",emailAdress);
		
		registerPage.clickToTextboxByLabel(driver,"Newsletter");
		
		log.info("Register - Step 05: Enter to Password textbox with value is '" + userData.getLoginPassword() + "'");
		registerPage.inputTextboxByID(driver,"Password",userData.getLoginPassword());
		
		log.info("Register - Step 06: Enter to Confirm Password textbox with value is '" + userData.getLoginPassword() + "'");
		registerPage.inputTextboxByID(driver,"ConfirmPassword",userData.getLoginPassword());
		
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
		
		log.info("Login - Step 03: Enter to Password textbox with value is '" + userData.getLoginPassword() + "'");
		loginPage.inputTextboxByID(driver,"Password",userData.getLoginPassword());
		
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
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver,"FirstName"), userData.getFirstName());
		
		log.info("My Account - Step 04: Verify 'Last Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver,"LastName"),userData.getLastName());
		
		log.info("My Account - Step 05: Verify 'Email' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver,"Email"), emailAdress);
		
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}
	private WebDriver driver;
	private String emailAdress;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	UserDataMapper userData;
	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
	

}
