package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.HomePageObject;
import pageFactory.RegisterPageObject;
import pageFactory.LoginPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Level_05_Page_Factory extends BaseTest{
	private WebDriver driver;
	private String firstName, invalidEmail, notFoundEmail, existingEmail, lastName, password, incorrectPassword;
	String day, month, year;
	String projectLocaion = System.getProperty("user.dir");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
 
		firstName = "Tran";
		lastName = "Tuyen";
		existingEmail = "tuyen" + randomNumber() + "@mail.vn";
		notFoundEmail = "tuyen" + randomNumber() + "@mail.com";
		invalidEmail = "afc@adc@acb.com";
		password = "123456";
		incorrectPassword = "654321";
		day = "12";
		month = "August";
		year = "1992";
		
		System.out.println("Pre-Condition - Step 01: click to Register link");
		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);

		System.out.println("Pre-Condition - Step 02: input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Pre-Condition - Step 03: click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-Condition - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

		System.out.println("Pre-Condition - Step 05: Click to logout link");
		registerPage.clickToLogoutLink();
		
		homePage = new HomePageObject(driver);
	}
	
	@Test
	public void Login_01_Empty_Data() {
	
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver);
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
		

	}

	@Test
	public void Login_02_Invalid_Email() {
		
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(invalidEmail);
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {
		
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(notFoundEmail);
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		

	}
	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);
		
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}
	@Test
	public void TC_06_Valid_Email_Password() {
		
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(password);
		
		loginPage.clickToLoginButton();
		
		homePage = new HomePageObject(driver);
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
	

}
