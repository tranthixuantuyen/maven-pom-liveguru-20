package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_12_Assert_Verify extends BaseTest{
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
	
	@Test
	public void User_01_Register_Login() {
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAdress);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
	//	Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		verifyEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed..");
		

		homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextbox(emailAdress);
		loginPage.inputToPasswordTextbox(validPassword);
		
		homePage = loginPage.clickToLoginButton();
	//	Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		verifyFalse(homePage.isMyAccountLinkDisplayed());
		
		customerInforPage = homePage.clickToMyAccountLink();
	//	Assert.assertTrue(customerInforPage.isCustomerInforDisplayed());
		verifyFalse(customerInforPage.isCustomerInforDisplayed());
	}

	
	
	public void User_02_Dynamic_Locator() {
		// Customer infor -> Address
		addressPage = customerInforPage.openAddressPage(driver);
		
		//Address -> My product review
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		
		//My product review -> Reward Point
		rewardPointPage = myProductReviewPage.openRewardPoint(driver);
				
		// Reward Point -> Address
		addressPage =	rewardPointPage.openAddressPage(driver);
		
		//Address -> Reward Point
		rewardPointPage = addressPage.openRewardPoint(driver);
		
		//Reward Point -> My product review
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
	}
	
	
	public void User_03_Dynamic_Page_Solution_01() {
		
		//My product review -> Reward Point
		rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver, "Reward points");
				
		// Reward Point -> Address
		addressPage =	(UserAddressesPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "Addresses");
		
		//Address -> Reward Point
		rewardPointPage = (UserRewardPointPageObject) addressPage.openPagesAtMyAccountByName(driver, "Reward points");
		
		//Reward Point -> My product review
		myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "My product reviews");
		
		//My product review -> Customer Info
		customerInforPage = (UserCustomerInforPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver, "Customer info");
	}
	
	
	public void User_03_Dynamic_Page_Solution_02() {
		//Customer Info -> My product review
		customerInforPage.openPagesAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		
		//My product review -> Reward Point
		myProductReviewPage.openPagesAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
				
		// Reward Point -> Address
		rewardPointPage.openPagesAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressesPage(driver);
		
		//Address -> Reward Point
		addressPage.openPagesAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
		
		//Reward Point -> My product review
		rewardPointPage.openPagesAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
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
	private UserAddressesPageObject addressPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;
	

}
