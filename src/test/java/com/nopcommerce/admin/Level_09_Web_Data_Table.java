package com.nopcommerce.admin;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.admin.AdminProductPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Level_09_Web_Data_Table extends AbstractTest{

	WebDriver driver;
	
	@Parameters(value={"browser","url"})
	@BeforeTest
	public void beforeTest(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		
		loginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		dashboardPage = loginPage.loginToSystem("admin@yourstore.com","admin");
		productPage = dashboardPage.openProductPage();
	}

	@Test
	public void TC_01_Paging() {
		  // Click phân trang
		  productPage.goToPageAtTableByIndex("2");
		  productPage.sleepInSecond(3);
		  Assert.assertTrue(productPage.isPageActivedTableByIndex("2"));
		  
		  productPage.goToPageAtTableByIndex("3");
		  productPage.sleepInSecond(3);
		  Assert.assertTrue(productPage.isPageActivedTableByIndex("3"));
		 
		  productPage.goToPageAtTableByIndex("1");
		  productPage.sleepInSecond(3);
		  Assert.assertTrue(productPage.isPageActivedTableByIndex("1"));
	}

	@Test
	public void TC_02_Select_Deselect_All() {
		// Select All
		productPage.checkToSelectAllCheckbox();
		// Deselect All
		productPage.uncheckToSelectAllCheckbox();

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	AdminLoginPageObject loginPage;
	AdminDashboardPageObject dashboardPage;
	AdminProductPageObject productPage;
}
