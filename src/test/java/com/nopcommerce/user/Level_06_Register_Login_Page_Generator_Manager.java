package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.user.UserCustomerInforPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Level_06_Register_Login_Page_Generator_Manager extends AbstractTest{

	WebDriver driver;
	
	String firstName, email, lastName, companyName, password;
	String day, month, year;
	
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInforPageObject customerInforPage;
	
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);

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
		homePage = new UserHomePageObject(driver);
		
		registerPage = homePage.clickToRegisterLink();	
		
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
		
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_02_LoginToSystem() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
	public void TC_03_ViewMyAccount() {
		customerInforPage = homePage.clickToMyAccountLink();
		
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
}
