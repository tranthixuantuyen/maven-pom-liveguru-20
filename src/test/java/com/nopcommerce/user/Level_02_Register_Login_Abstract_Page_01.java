package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.AbstractPage;

import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Level_02_Register_Login_Abstract_Page_01 {
	String projectLocaion = System.getProperty("user.dir");
	private WebDriver driver;
	private String firstName, email, lastName, companyName, password;
	
	AbstractPage abstractPage;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.firefox.driver", projectLocaion + "\\browserDrivers\\firefoxdriver.exe");
		driver = new FirefoxDriver();
		
		abstractPage = new AbstractPage();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		abstractPage.openUrl(driver, "https://demo.nopcommerce.com/");

		firstName = "Tran";
		lastName = "Tuyen";
		companyName = "Demo";
		email = "tuyen" + randomNumber() + "@hotmail.com";
		password = "123456";
	}

	@Test
	public void TC_01_RegisterToSystem() {
		abstractPage.clickToElement(driver, "//a[@class='ico-register']");
		
		abstractPage.clickToElement(driver, "//input[@id='gender-male']");
		abstractPage.sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		abstractPage.sendkeyToElement(driver, "//input[@id='LastName']", lastName);
		
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "12");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "August");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1992");
		
		abstractPage.sendkeyToElement(driver,"//input[@id='Email']", email);
		abstractPage.sendkeyToElement(driver,"//input[@id='Company']", companyName);
		abstractPage.sendkeyToElement(driver,"//input[@id='Password']", password);
		abstractPage.sendkeyToElement(driver,"//input[@id='ConfirmPassword']", password);
		
		abstractPage.clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(abstractPage.getElementText(driver, "//div[@class='page registration-result-page']//div[@class='result']"), "Your registration completed");
		
		abstractPage.clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test
	public void TC_02_LoginToSystem() {
		abstractPage.clickToElement(driver, "//a[@class='ico-login']");
		
		abstractPage.sendkeyToElement(driver, "//input[@id='Email']", email);
		abstractPage.sendkeyToElement(driver, "//input[@id='Password']", password);
		
		abstractPage.clickToElement(driver, "//button[text()='Log in']");
		
		Assert.assertTrue(abstractPage.isElementDisplayed(driver, "//a[@class='ico-account']"));
		Assert.assertTrue(abstractPage.isElementDisplayed(driver, "//a[@class='ico-logout']"));
	}

	@Test
	public void TC_03_ViewMyAccount() {
		
		abstractPage.clickToElement(driver, "//a[@class='ico-account']");
		
		Assert.assertTrue(abstractPage.isElementSelected(driver, "//input[@id='gender-male']"));
		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='FirstName']", "value"),firstName);
		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='LastName']", "value"),lastName);
		
		Assert.assertEquals(abstractPage.getFirstSelectedTextInDropdown(driver, "//select[@name='DateOfBirthDay']"), "12");
		Assert.assertEquals(abstractPage.getFirstSelectedTextInDropdown(driver, "//select[@name='DateOfBirthMonth']"), "August");
		Assert.assertEquals(abstractPage.getFirstSelectedTextInDropdown(driver, "//select[@name='DateOfBirthYear']"), "1992");
		
		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='Email']", "value"),email);
		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='Company']", "value"),companyName);

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
