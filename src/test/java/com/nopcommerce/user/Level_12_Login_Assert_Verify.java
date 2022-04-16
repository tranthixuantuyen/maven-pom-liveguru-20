package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Level_12_Login_Assert_Verify extends AbstractTest{

	WebDriver driver;
	
	String firstName, email, lastName, companyName, password;
	String day, month, year;
	
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	
	@Parameters({"browser", "url"})
	@BeforeTest
	public void beforeTest(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);

	}

	@Test
	public void TC_01_Assert() {
		System.out.println("Step 11 -Failed");
		Assert.assertTrue(false);
		System.out.println("Step 12 -Pass");
		Assert.assertTrue(true);
		System.out.println("Step 13 -Failed");
		Assert.assertFalse(true);
		System.out.println("Step 14 -Pass");
		Assert.assertFalse(false);
		
	}

	@Test
	public void TC_02_Verify() {
		System.out.println("Step 21 -Failed");
		verifyTrue(false);
		System.out.println("Step 22 -Pass");
		verifyTrue(true);
		System.out.println("Step 23 -Failed");

		verifyFalse(true);
		System.out.println("Step 24 -Pass");
		verifyFalse(false);


	}


	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
