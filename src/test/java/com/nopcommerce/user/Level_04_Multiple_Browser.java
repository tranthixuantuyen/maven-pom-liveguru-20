package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Level_04_Multiple_Browser extends BaseTest{
	private WebDriver driverTestClass;
	private String firstName, email, lastName, password;
	String day, month, year;
	String projectLocaion = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driverTestClass = getBrowserDriver(browserName);

		homePage = new UserHomePageObject(driverTestClass);
		registerPage = new UserRegisterPageObject(driverTestClass);

		firstName = "Tran";
		lastName = "Tuyen";
		email = "tuyen" + randomNumber() + "@hotmail.com";
		password = "123456";
		day = "12";
		month = "August";
		year = "1992";

	}

	@Test
	public void Register_01_Empty_Data() {
		
		System.out.println("Home Page - Step 01: click to Register link");
		homePage.clickToRegisterLink();

		registerPage = new UserRegisterPageObject(driverTestClass);

		System.out.println("Register Page - Step 02: click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 03: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
		 
	}

	@Test
	public void Register_02_Register_Invalid_Email() {
		
		  System.out.println("Home Page - Step 01: click to Register link");
		  homePage.clickToRegisterLink();
		  
		  registerPage = new UserRegisterPageObject(driverTestClass);
		  
		  System.out.println("Register Page - Step 02: input to required fields");
		  registerPage.inputToFirstNameTextbox(firstName);
		  registerPage.inputToLastNameTextbox(lastName);
		  registerPage.inputToEmailTextbox("123@$%^");
		  registerPage.inputToPasswordTextbox(password);
		  registerPage.inputToConfirmPasswordTextbox(password);
		  
		  System.out.println("Register Page - Step 03: click to Register button");
		  registerPage.clickToRegisterButton();
		  
		  System.out.println("Register Page - Step 04: Verify error message displayed"
		  ); Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox()
		  ,"Wrong email");
		 
	}


	public void Register_03_Register_Success() {
		System.out.println("Home Page - Step 01: click to Register link");
		
		  homePage.clickToRegisterLink();
		  
		  registerPage = new UserRegisterPageObject(driverTestClass);
		  
		  System.out.println("Register Page - Step 02: input to required fields");
		  registerPage.inputToFirstNameTextbox(firstName);
		  registerPage.inputToLastNameTextbox(lastName);
		  registerPage.inputToEmailTextbox(email);
		  registerPage.inputToPasswordTextbox(password);
		  registerPage.inputToConfirmPasswordTextbox(password);
		  
		  System.out.println("Register Page - Step 03: click to Register button");
		  registerPage.clickToRegisterButton();
		  
		  System.out.
		  println("Register Page - Step 04: Verify success message displayed");
		  Assert.assertEquals(registerPage.getRegisterSuccessMessage()
		  ,"Your registration completed");
		  
		  System.out.println("Register Page - Step 05: Click to logout link");
		  registerPage.clickToLogoutLink();
		 

	}


	public void Register_04_Register_Existing_Email() {
		
		  System.out.println("Home Page - Step 01: click to Register link");
		  homePage.clickToRegisterLink();
		  
		  registerPage = new UserRegisterPageObject(driverTestClass);
		  
		  System.out.println("Register Page - Step 02: input to required fields");
		  registerPage.inputToFirstNameTextbox(firstName);
		  registerPage.inputToLastNameTextbox(lastName);
		  registerPage.inputToEmailTextbox(email);
		  registerPage.inputToPasswordTextbox(password);
		  registerPage.inputToConfirmPasswordTextbox(password);
		  
		  System.out.println("Register Page - Step 03: click to Register button");
		  registerPage.clickToRegisterButton();
		  
		  System.out.println("Register Page - Step 04: Verify error message displayed"
		  ); Assert.assertEquals(registerPage.getErrorExistingEmailMessage()
		  ,"The specified email already exists");
		 
	}

	
	public void Register_05_Register_Password_Less_Than_6_Chars() {
		System.out.println("Home Page - Step 01: click to Register link");
		homePage.clickToRegisterLink();
		
		registerPage = new UserRegisterPageObject(driverTestClass);

		System.out.println("Register Page - Step 02: input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");

		System.out.println("Register Page - Step 03: click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password must meet the following rules:\nmust have at least 6 characters");
	}

	
	public void Register_06_Register_Invalid_Confirm_Password() {
		System.out.println("Home Page - Step 01: click to Register link");
		homePage.clickToRegisterLink();
		
		registerPage = new UserRegisterPageObject(driverTestClass);

		System.out.println("Register Page - Step 02: input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("654321");

		System.out.println("Register Page - Step 03: click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"The password and confirmation password do not match.");
	}

	@AfterTest
	public void afterTest() {
		driverTestClass.quit();
	}

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
}
