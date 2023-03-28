package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Level_16_Share_Data extends BaseTest{

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
 
		emailAdress = Common_01_Register_End_User.emailAdress;
		validPassword = Common_01_Register_End_User.validPassword;
		
		log.info("Login - Step 01: Navigate to Login page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 02: Enter to Email textbox with value is '" + emailAdress + "'");
		loginPage.inputToEmailTextbox(emailAdress);
		
		log.info("Login - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inputToPasswordTextbox(validPassword);
		
		log.info("Login - Step 04: Click to 'Register' button");
		homePage = loginPage.clickToLoginButton();
		
	}
	
	@Test
	public void Search_01_Empty_Data() {

	}
	
	@Test
	public void Search_02_Relative_Product_Name() {

	}
	
	@Test
	public void Search_03_Absolute_Product_Name() {

	}
	
	@Test
	public void Search_04_Parent_Category() {

	}
	
	@Test
	public void Search_05_Incorrect_Manufactorer() {

	}
	
	@Test
	public void Search_06_Correct_Manufactorer() {

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
	private UserLoginPageObject loginPage;
	private WebDriver driver;
	private String emailAdress, validPassword;
}
