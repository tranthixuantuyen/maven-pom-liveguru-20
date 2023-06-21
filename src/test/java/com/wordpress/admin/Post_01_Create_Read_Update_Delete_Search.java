package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.*;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminPostAddNewPO;
import pageObjects.wordpress.AdminPostSearchPO;
import pageObjects.wordpress.UserHomePO;
import pageObjects.wordpress.UserPostDetailPO;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest{
	private WebDriver driver;
	String adminUsername = "automationfc";
	String adminPassword= "automationfc";
	int randomNumber = 	randomNumber();
	String postTitle = "Live Coding Title "+ randomNumber;
	String postBody = "Live Coding Body "+ randomNumber;
	String searchPostUrl;
	String editPostTitle = "Edit Title"+ randomNumber;
	String editPostBody = "Edit Body"+ randomNumber;
	String authorName = "Automation Admin";
	String adminUrl, endUserUrl;
	String currentDay = getCurrentDay();
	
	@Parameters({"browser", "urlAdmin", "endUserUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		log.info("Pre-Condition - Step 01: Open browser with url");
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
		driver = getBrowserDriver(browserName,this.adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Pre-Condition - Step 02: Enter to Username textbox with value " + adminUsername);
		adminLoginPage.enterToUserNameTextbox(adminUsername);
		
		log.info("Pre-Condition - Step 03: Enter to Password textbox with value " + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);
		
		log.info("Pre-Condition - Step 04: Click to login button");
		adminDashboarPage = adminLoginPage.clickToLoginButton();
		
	}
	
	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create_Post - Step 01: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboarPage.clickToPostMenuLink();

		log.info("Create_Post - Step 02: Get 'Search Posts' page Url");
		searchPostUrl = adminPostSearchPage.getCurrentPageUrl(driver);
		
		log.info("Create_Post - Step 03: Click to 'Add New' button");
		adminPostAddNewPage= adminPostSearchPage.clickToAddNewButton();
		
		log.info("Create_Post - Step 04: Enter to post title");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitle);
		
		log.info("Create_Post - Step 05: Enter to body");
		adminPostAddNewPage.enterToAddNewPostBody(postBody);
		
		log.info("Create_Post - Step 06: Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishOrUpdateButton();

		log.info("Create_Post - Step 07: Click to 'Pre Publish' button");
		adminPostAddNewPage.clickToPrePublishButton();

		log.info("Create_Post - Step 08: Verify 'Post published' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post published."));
	}

	@Test
	public void Post_02_Search_And_View_Post() {
		log.info("Search_Post - Step 01: Open 'Search Posts' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

		log.info("Search_Post - Step 02: Enter to search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);

		log.info("Search_Post - Step 03: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchButton();

		log.info("Search_Post - Step 04: Verify Search table contains '" + postTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", postTitle));

		log.info("Search_Post - Step 05: Verify Search table contains '" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

		log.info("Search_Post - Step 06: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Search_Post - Step 07: Verify Post infor displayed at Home page");
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(postTitle));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostAuthor(postTitle, authorName));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostCurrentDay(postTitle, currentDay));

		log.info("Search_Post - Step 08: Click to Post title");
		userPostDeatilPage = userHomePage.clickToPostTitle(postTitle);

		log.info("Search_Post - Step 09: Verify Post infor displayed at Post detail page");
		verifyTrue(userPostDeatilPage.isPostInforDisplayedWithPostTitle(postTitle));
		verifyTrue(userPostDeatilPage.isPostInforDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userPostDeatilPage.isPostInforDisplayedWithPostAuthor(postTitle, authorName));
		verifyTrue(userPostDeatilPage.isPostInforDisplayedWithPostCurrentDay(postTitle, currentDay));
	}
	@Test
	public void Post_03_Edit_Post() {
		log.info("Edit_Post - Step 01: Open Admin site");
		adminDashboarPage = userPostDeatilPage.openAdminSite(driver, this.adminUrl);

		log.info("Edit_Post - Step 02: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboarPage.clickToPostMenuLink();

		log.info("Edit_Post - Step 03: Enter to Search textbox ");
		adminPostSearchPage.enterToSearchTextbox(postTitle);

		log.info("Edit_Post - Step 04: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchButton();

		log.info("Edit_Post - Step 05: Click to Post title link and navigate to Edit Post page");
		adminPostAddNewPage = adminPostSearchPage.clickToPostTitleLink(postTitle);

		log.info("Edit_Post - Step 06: Enter to post title");
		adminPostAddNewPage.enterToAddNewPostTitle(editPostTitle);

		log.info("Edit_Post - Step 07 : Enter to post body");
		adminPostAddNewPage.enterToEditPostBody(editPostBody);

		log.info("Edit_Post - Step 08 : Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishOrUpdateButton();

		log.info("Edit_Post - Step 09: Verify 'Post updated.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post updated."));

		log.info("Edit_Post - Step 10: Open 'Search Posts' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);

		log.info("Edit_Post - Step 11: Enter to search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);

		log.info("Edit_Post - Step 12: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchButton();

		log.info("Edit_Post - Step 13: Verify Search table contains '" + editPostTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", editPostTitle));

		log.info("Edit_Post - Step 14: Verify Search table contains '" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

		log.info("Edit_Post - Step 15: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Edit_Post - Step 16: Verify Post infor displayed at Home page");
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(editPostTitle));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(editPostTitle, editPostBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostAuthor(editPostTitle, authorName));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostCurrentDay(editPostTitle, currentDay));

		log.info("Edit_Post - Step 17: Click to Post title");
		userPostDeatilPage = userHomePage.clickToPostTitle(editPostTitle);

		log.info("Edit_Post - Step 18: Verify Post infor displayed at Post detail page");
		verifyTrue(userPostDeatilPage.isPostInforDisplayedWithPostTitle(editPostTitle));
		verifyTrue(userPostDeatilPage.isPostInforDisplayedWithPostBody(editPostTitle, editPostBody));
		verifyTrue(userPostDeatilPage.isPostInforDisplayedWithPostAuthor(editPostTitle, authorName));
		verifyTrue(userPostDeatilPage.isPostInforDisplayedWithPostCurrentDay(editPostTitle, currentDay));

	}

	@Test
	public void Post_04_Delete_Post() {
		log.info("Delete_Post - Step 01: Open Admin site");
		adminDashboarPage = userPostDeatilPage.openAdminSite(driver, this.adminUrl);

		log.info("Delete_Post - Step 02: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboarPage.clickToPostMenuLink();

		log.info("Delete_Post - Step 03: Enter to search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);

		log.info("Delete_Post - Step 04: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchButton();

		log.info("Delete_Post - Step 05: Select Post detail checkbox");
		adminPostSearchPage.selectPostCheckboxByTitle(editPostTitle);

		log.info("Delete_Post - Step 06: Select 'Move to Trash' item in dropdown");
		adminPostSearchPage.selectTextItemActionDropdown("Move to Trash");

		log.info("Delete_Post - Step 07: Click to 'Apply' button");
		adminPostSearchPage.clickToApplyButton();

		log.info("Delete_Post - Step 08: Verify '1 post moved to the Trash.' message is displayed");
		verifyTrue(adminPostSearchPage.isMoveToTrashMessageDisplayed("1 post moved to the Trash. "));

		log.info("Delete_Post - Step 09: Enter to Search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);

		log.info("Delete_Post - Step 10: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchButton();

		log.info("Delete_Post - Step 11: Verify 'No posts found.' message is displayed");
		verifyTrue(adminPostSearchPage.isNoPostFoundMessageDisplayed("No posts found."));

		log.info("Delete_Post - Step 12: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Delete_Post - Step 13: Verify Post title undisplayed at Home page");
		verifyTrue(userHomePage.isNoPostInfoUndisplayedWithPostTitle(editPostTitle));

		log.info("Delete_Post - Step 14: Enter to Search textbox");
		userHomePage.enterToSearchTextbox(editPostTitle);

		log.info("Delete_Post - Step 15: Click to 'Search' button");
		userSearchPostPage = userHomePage.clickToSearchButton();

		log.info("Delete_Post - Step 16: Verify 'Nothing Found' message is displayed");
		verifyTrue(userSearchPostPage.isNothingFoundMessageDisplayed("Nothing Found"));

	}

	@AfterClass(alwaysRun = true)
	public void afterClass(){
		closeBrowserAndDriver();
	}
	
	private AdminLoginPO adminLoginPage;
	private AdminDashboardPO adminDashboarPage;
	private AdminPostSearchPO adminPostSearchPage;
	private AdminPostAddNewPO adminPostAddNewPage;
	private UserHomePO userHomePage;
	private UserPostDetailPO userPostDeatilPage;
	private UserSearchPostPO userSearchPostPage;
	

}
