package com.wordpress.admin;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.wordpress.*;

public class User_01_View_User extends BaseTest{
	@Parameters({"browser", "urlAdmin", "endUserUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		log.info("Pre-Condition - Step 01: Open browser with url");
		driver = getBrowserDriver(browserName,adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Pre-Condition - Step 02: Enter to Username textbox with value " + adminUsername);
		adminLoginPage.enterToUserNameTextbox(adminUsername);
		
		log.info("Pre-Condition - Step 03: Enter to Password textbox with value " + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);
		
		log.info("Pre-Condition - Step 04: Click to login button");
		adminDashboarPage = adminLoginPage.clickToLoginButton();
		
	}
	
	@Test
	public void TC_01_View_User() {
		log.info("View_User - Step 01: Click to 'Posts' menu link");
		adminUserPage = adminDashboarPage.clickToUserMenuLink();

		log.info("View_User - Step 02: Get all users from UI");
		int totalNumberUserAtUI = adminUserPage.getUserNumberAtUI();

		log.info("View_User - Step 03: Get all users from DB");
		int totalNumberUserAtDB = adminUserPage.getUserNumberAtDB();

		log.info("View_User - Step 04: Verify the User are matching");
		verifyEquals(totalNumberUserAtUI,totalNumberUserAtDB);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass(){
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	String adminUsername = "automationfc";
	String adminPassword= "automationfc";
	private AdminLoginPO adminLoginPage;
	private AdminDashboardPO adminDashboarPage;
	private AdminUserPO adminUserPage;


}
