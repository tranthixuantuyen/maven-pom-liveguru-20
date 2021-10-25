package com.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Level_01_Register_Login_Step_By_Step {
	String projectLocaion = System.getProperty("user.dir");
	private WebDriver driver;
	private Select select;
	private String firstName, email, lastName, companyName, password;
	Actions action;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", projectLocaion + "\\browserDrivers\\chromedriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

		firstName = "Tran";
		lastName = "Tuyen";
		companyName = "Demo";
		email = "tuyen" + randomNumber() + "@hotmail.com";
		password = "123456";
	}

	@Test
	public void TC_01_RegisterToSystem() {
		// Click to Register link
		driver.findElement(By.cssSelector(".ico-register")).click();

		// Click male radio button
		driver.findElement(By.cssSelector("#gender-male")).click();
		driver.findElement(By.cssSelector("#FirstName")).sendKeys(firstName);
		driver.findElement(By.cssSelector("#LastName")).sendKeys(lastName);

		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
		select.selectByVisibleText("12");

		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
		select.selectByVisibleText("August");

		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
		select.selectByVisibleText("1992");

		driver.findElement(By.cssSelector("#Email")).sendKeys(email);
		;
		driver.findElement(By.cssSelector("#Company")).sendKeys(companyName);
		driver.findElement(By.cssSelector("#Password")).sendKeys(password);
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(password);

		driver.findElement(By.cssSelector("#register-button")).click();

		// Verify registered success
		String resultText = driver.findElement(By.cssSelector(".result")).getText();
		Assert.assertEquals(resultText, "Your registration completed");

		System.out.println("email:" + email + " + pass: " + password);

		// Logout system
		driver.findElement(By.cssSelector(".ico-logout")).click();
	}

	@Test
	public void TC_02_LoginToSystem() {
		// Click login link
		driver.findElement(By.cssSelector(".ico-login")).click();

		driver.findElement(By.cssSelector("#Email")).sendKeys(email);
		driver.findElement(By.cssSelector("#Password")).sendKeys(password);

		driver.findElement(By.cssSelector("button[class='button-1 login-button']")).click();

		// verify My Account link displayed
		Assert.assertTrue(driver.findElement(By.cssSelector(".ico-account")).isDisplayed());
	}

	@Test
	public void TC_03_ViewMyAccount() {

		driver.findElement(By.cssSelector(".ico-acc                               ount")).click();

		Assert.assertTrue(driver.findElement(By.cssSelector("gender-male")).isSelected());
		Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastName);

		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "12");

		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "August");

		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "1992");

		Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), email);
		Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"), companyName);

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
