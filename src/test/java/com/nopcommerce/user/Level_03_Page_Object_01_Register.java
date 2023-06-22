package com.nopcommerce.user;

import org.testng.annotations.Test;

import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Level_03_Page_Object_01_Register {
	private WebDriver driver;
	private String firstName, email, lastName, password;
	String day, month, year;
	String projectLocaion = System.getProperty("user.dir");

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", projectLocaion + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
				
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
		homePage = new UserHomePageObject(driver);
		registerPage = new UserRegisterPageObject(driver);
 
		firstName = "Tran";
		lastName = "Tuyen";
		email = "tuyen" + randomNumber() + "@hotmail.com";
		password = "123456";
		day = "12";
		month = "August";
		year = "1992";
	}
	
	@Test
	public void Register_01_Empty_Data() {;
		System.out.println("Home Page - Step 01: click to Register link");
		homePage.clickToRegisterLink();
		
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register Page - Step 02: click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 03: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(),"First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(),"Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"Password is required.");
	}

	@Test
	public void Register_02_Register_Invalid_Email() {
		System.out.println("Home Page - Step 01: click to Register link");
		homePage.clickToRegisterLink();
		
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register Page - Step 02: input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("123@$%^");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register Page - Step 03: click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Wrong email");
	}

	@Test
	public void Register_03_Register_Success() {
		System.out.println("Home Page - Step 01: click to Register link");
		homePage.clickToRegisterLink();
		
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register Page - Step 02: input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register Page - Step 03: click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

		System.out.println("Register Page - Step 05: Click to logout link");
		registerPage.clickToLoginLink();

	}

	@Test
	public void Register_04_Register_Existing_Email() {
		System.out.println("Home Page - Step 01: click to Register link");
		homePage.clickToRegisterLink();
		
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register Page - Step 02: input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register Page - Step 03: click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(),"The specified email already exists");
	}
	@Test
	public void Register_05_Register_Password_Less_Than_6_Chars() {
		System.out.println("Home Page - Step 01: click to Register link");
		homePage.clickToRegisterLink();
		
		registerPage = new UserRegisterPageObject(driver);

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
	@Test
	public void Register_06_Register_Invalid_Confirm_Password() {
		System.out.println("Home Page - Step 01: click to Register link");
		homePage.clickToRegisterLink();
		
		registerPage = new UserRegisterPageObject(driver);

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
		driver.quit();
	}

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
	
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
}
