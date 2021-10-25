package com.nopcommerce.user;

import org.testng.annotations.Test;

import pageObjects.UserCustomerInfoPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserRegisterPO;

import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Level_03_Register_Login_Page_Object {
	String projectLocaion = System.getProperty("user.dir");
	private WebDriver driver;
	
	private String firstName, email, lastName, companyName, password;
	String day, month, year;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.firefox.driver", projectLocaion + "\\browserDrivers\\firefoxdriver.exe");
		driver = new FirefoxDriver();
				
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
 
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
		homePage = new UserHomePO(driver);
		homePage.clickToRegisterLink();	
		registerPage = new UserRegisterPO(driver);
		
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
		
		registerPage.clickToLogoutLink();
		homePage = new UserHomePO(driver);
	}

	@Test
	public void TC_02_LoginToSystem() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPO(driver);
		
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		homePage = new UserHomePO(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
	public void TC_03_ViewMyAccount() {
		homePage.clickToMyAccountLink();
		customerInforPage = new UserCustomerInfoPO(driver);
		
		Assert.assertTrue(customerInforPage.isGenderMaleRadioButtonSelected());
		Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(),firstName);
		Assert.assertEquals(customerInforPage.getLastNameTextboxValue(),lastName);
		Assert.assertEquals(customerInforPage.getSelectedTextDayDropDown(),day);
		Assert.assertEquals(customerInforPage.getSelectedTextMonthDropDown(),month);
		Assert.assertEquals(customerInforPage.getSelectedTextYearDropDown(),year);
		Assert.assertEquals(customerInforPage.getEmailTextboxValue(),email);
		Assert.assertEquals(customerInforPage.getCompanyTextboxValue(),companyName);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
	
	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserCustomerInfoPO customerInforPage;
}