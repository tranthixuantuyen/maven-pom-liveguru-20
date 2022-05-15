package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Level_08_Switch_Role extends BaseTest{
	private WebDriver driver;
	private String  userEmailAddress, userPassword, adminEmailAddress, adminPassword;
	private String firstName, lastName;

	@Parameters({"browser","enviroment"})
	@BeforeTest
	public void beforeTest(String browserName, String enviromentName) {
		driver = getBrowserDriver(browserName,enviromentName);
		
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
 
		userEmailAddress = "tuyen" + randomNumber() + "@mail.vn";
		userPassword = "123456";
		firstName = "Tran";
		lastName = "Tuyen";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
		
		registerPage = userHomePage.clickToRegisterLink();
		
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(userEmailAddress);
		registerPage.inputToPasswordTextbox(userPassword);
		registerPage.inputToConfirmPasswordTextbox(userPassword);
		System.out.print("User email name: " + userEmailAddress);
		System.out.print("Pass: " + userPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

		userHomePage = registerPage.clickToLogoutLink();
		
	}
	@Test
	public void Role_01_User() {
		userLoginPage = userHomePage.clickToLoginLink();
		
		// Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress,userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		
		// Home Page -> Customer Info
		customerInforPage = userHomePage.clickToMyAccountLink();
		
		// Customer Info click logout -> Home Page
		userHomePage = customerInforPage.clickLogoutLinkAtUserPage(driver);
		
		// User Home Page -> Open Admin -> Login Page Admin
		userHomePage.openUrl(driver, GlobalConstants.DEV_ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		// Login as Admin Role
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
		
		// Dashboard Page -> Click Logout -> login Page(Admin)
		adminLoginPage = adminDashboardPage.clickLogoutLinkAtAdminPage(driver);
		
		
	}
	
	@Test
	public void Role_02_Admin_To_User() {
		adminDashboardPage.openUrl(driver, GlobalConstants.DEV_PORTAL_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		
		// User HomePage -> Login Page (User)
		userLoginPage = userHomePage.clickToLoginLink();
		
		// Login as User Role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());	
		
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
	
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserRegisterPageObject registerPage;
	private UserCustomerInforPageObject customerInforPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;

	

}
