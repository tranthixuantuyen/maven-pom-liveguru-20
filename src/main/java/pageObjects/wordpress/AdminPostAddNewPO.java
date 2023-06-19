package pageObjects.wordpress;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.wordpress.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage {
    WebDriver driver;
    public AdminPostAddNewPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToAddNewPostTitle(String postTitle) {
        waitForElementVisible(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX);
        sendkeyToElement(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX,postTitle );
    }

    public void enterToAddNewPostBody(String postBody) {
        //Click
        waitForElementClickable(driver, AdminPostAddNewPageUI.BODY_BUTTON);
        clickToElement(driver, AdminPostAddNewPageUI.BODY_BUTTON);
        // Sendkey
        waitForElementVisible(driver,AdminPostAddNewPageUI.BODY_TEXTBOX);
        sendkeyToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX,postBody );
    }

    public void clickToPublishOrUpdateButton() {
        waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
        clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON );
    }

    public void clickToPrePublishButton() {
        waitForElementClickable(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
        clickToElement(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON );
    }

    public boolean isPostPublishMessageDisplayed(String postPublishedMessage) {
        waitForElementVisible(driver,AdminPostAddNewPageUI.PUBLISHED_MESSAGE,postPublishedMessage);
        return isElementDisplayed(driver,AdminPostAddNewPageUI.PUBLISHED_MESSAGE,postPublishedMessage);
    }

    public AdminPostSearchPO openSearchPostPageUrl(String searchPostUrl) {
        openUrl(driver,searchPostUrl);
        return PageGeneratorManager.getAdminPostSearchPage(driver);
    }

    public void enterToEditPostBody(String postBodyValue) {
        waitForElementClickable(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
        clickToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX );

        waitForElementVisible(driver,AdminPostAddNewPageUI.BODY_TEXTBOX);
        clearValueInElementByDeleteKey(driver,AdminPostAddNewPageUI.BODY_TEXTBOX);
        sendkeyToElement(driver,AdminPostAddNewPageUI.BODY_TEXTBOX,postBodyValue );

    }
}
