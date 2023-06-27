package com.facebook.register;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Level_13_Element_Undisplayed extends BaseTest{
	private WebDriver driver;
	private LoginPageObject loginPage;
	

	@Parameters({"browser", "enviroment"})
	@BeforeTest
	public void beforeTest(String browserName, String enviroment) {
		driver = getBrowserDriver(browserName, enviroment);
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}
	
	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
		
		loginPage.enterToEmailAddressTextboxDisplayed("automationfc@gmail.com");
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());

	}
	
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		
		loginPage.enterToEmailAddressTextboxDisplayed("");
	//	verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed() );
		
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());

	}
	
	
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.closeIconAtRegisterForm();
		loginPage.sleepInSecond(3);
	//	verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed() );
		
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed() );

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
