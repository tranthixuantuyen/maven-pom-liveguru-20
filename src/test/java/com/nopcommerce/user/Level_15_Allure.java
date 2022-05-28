package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Level_15_Allure extends BaseTest{
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
	
	@Description("Register to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_01_Register_Login() {

		registerPage = homePage.clickToRegisterLink();
		

		registerPage.inputToFirstNameTextbox(firstName);
		
		registerPage.inputToLastNameTextbox(lastName);
		
		registerPage.inputToEmailTextbox(emailAdress);
		
		registerPage.inputToPasswordTextbox(validPassword);
		
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed...");
		
	}
	
	@Description("Login to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_02_Login() {
		homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextbox(emailAdress);
		
		loginPage.inputToPasswordTextbox(validPassword);
		
		homePage = loginPage.clickToLoginButton();
	//	Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		
		customerInforPage = homePage.clickToMyAccountLink();
	//	Assert.assertTrue(customerInforPage.isCustomerInforDisplayed());
		
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
