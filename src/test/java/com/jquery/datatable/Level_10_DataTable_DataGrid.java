package com.jquery.datatable;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGenaratorManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Level_10_DataTable_DataGrid extends BaseTest{
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;


	@Parameters({"browser","url"})
	@BeforeTest
	public void beforeTest(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGenaratorManager.getHomePage(driver);
		
		
	}
	
	@Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("2");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("2"));
		
		homePage.openPagingByPageNumber("20");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("20"));
		
		homePage.openPagingByPageNumber("7");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("7"));
		
		homePage.openPagingByPageNumber("18");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("18"));
		

	}

	
	@Test
	public void User_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);
		
		homePage.enterToHeaderTextboxByLabel("Females","276880");
		homePage.enterToHeaderTextboxByLabel("Country","Angola");
		homePage.enterToHeaderTextboxByLabel("Males","276472");
		homePage.enterToHeaderTextboxByLabel("Total","553353");
		homePage.sleepInSecond(3);
		
		homePage.enterToHeaderTextboxByLabel("Females","283821");
		homePage.enterToHeaderTextboxByLabel("Country","Algeria");
		homePage.enterToHeaderTextboxByLabel("Males","295140");
		homePage.enterToHeaderTextboxByLabel("Total","578961");
		homePage.sleepInSecond(3);

	}
	
	@Test
	public void User_03_Enter_To_Header() {
		//Doc du lieu cua file country.txt ra
		// Luu vao 1 List<String> = Expected value = expectedAllCountryValues;
		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
		Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);
	}
	

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
	
	private WebDriver driver;

	

}
