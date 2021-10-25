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

public class Level_02_Register_Login_Abstract_Page_02 extends AbstractPage{
	String projectLocaion = System.getProperty("user.dir");
	private WebDriver driver;
	private String firstName, email, lastName, companyName, password;


	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.firefox.driver", projectLocaion + "\\browserDrivers\\firefoxdriver.exe");
		driver = new FirefoxDriver();
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		openUrl(driver, "https://demo.nopcommerce.com/");

		firstName = "Tran";
		lastName = "Tuyen";
		companyName = "Demo";
		email = "tuyen" + randomNumber() + "@hotmail.com";
		password = "123456";
	}

	@Test
	public void TC_01_RegisterToSystem() {
		clickToElement(driver, "//a[@class='ico-register']");
		
		clickToElement(driver, "//input[@id='gender-male']");
		sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		sendkeyToElement(driver, "//input[@id='LastName']", lastName);
		
		selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "12");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "August");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1992");
		
		sendkeyToElement(driver,"//input[@id='Email']", email);
		sendkeyToElement(driver,"//input[@id='Company']", companyName);
		sendkeyToElement(driver,"//input[@id='Password']", password);
		sendkeyToElement(driver,"//input[@id='ConfirmPassword']", password);
		
		clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//div[@class='page registration-result-page']//div[@class='result']"), "Your registration completed");
		
		clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test
	public void TC_02_LoginToSystem() {
		clickToElement(driver, "//a[@class='ico-login']");
		
		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Password']", password);
		
		clickToElement(driver, "//button[text()='Log in']");
		
		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));
		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-logout']"));
	}

	@Test
	public void TC_03_ViewMyAccount() {
		
		clickToElement(driver, "//a[@class='ico-account']");
		
		Assert.assertTrue(isElementSelected(driver, "//input[@id='gender-male']"));
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='FirstName']", "value"),firstName);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='LastName']", "value"),lastName);
		
		Assert.assertEquals(getFirstSelectedTextInDropdown(driver, "//select[@name='DateOfBirthDay']"), "12");
		Assert.assertEquals(getFirstSelectedTextInDropdown(driver, "//select[@name='DateOfBirthMonth']"), "August");
		Assert.assertEquals(getFirstSelectedTextInDropdown(driver, "//select[@name='DateOfBirthYear']"), "1992");
		
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Email']", "value"),email);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Company']", "value"),companyName);

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
