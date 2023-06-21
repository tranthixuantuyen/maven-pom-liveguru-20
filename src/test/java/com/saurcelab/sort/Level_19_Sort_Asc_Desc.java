package com.saurcelab.sort;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.saurcelab.LoginPO;
import pageObjects.saurcelab.PageGenaratorManager;
import pageObjects.saurcelab.ProductPO;

public class Level_19_Sort_Asc_Desc extends BaseTest{

	@Parameters({"browser","appUrl"})
	@BeforeClass
	public void beforeTest(String browserName, String saurceUrl) {
		driver = getBrowserDriver(browserName,saurceUrl);
		loginPage = PageGenaratorManager.getLoginPO(driver);

		loginPage.enterToUsernameTextbox("standard_user");
		loginPage.enterToPasswordTextbox("secret_sauce");
		productPage = loginPage.clickToLoginButton();

	}
	
	@Test
	public void Sort_01_Name() {
		// Ascendin
		productPage.selectItemInProductSortDropdown("Name (A to Z)");
		Assert.assertTrue(productPage.isProductNameSortByAscending());

		//Descending
		productPage.selectItemInProductSortDropdown("Name (Z to A)");
		Assert.assertTrue(productPage.isProductNameSortByDescending());


	}
	
	@Test
	public void Sort_02_Price() {
		// AscendinG
		productPage.selectItemInProductSortDropdown("Price (low to high)");
		Assert.assertTrue(productPage.isProductPriceSortByAscending());

		//Descending
		productPage.selectItemInProductSortDropdown("Price (high to low)");
		Assert.assertTrue(productPage.isProductPriceSortByDescending());

	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}
	private WebDriver driver;
	LoginPO loginPage;
	ProductPO productPage;


}
