package pageObjects.wordpress;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.wordpress.AdminPostSearchPageUI;

public class AdminPostSearchPO extends BasePage {
    WebDriver driver;
    public AdminPostSearchPO(WebDriver driver) {
        this.driver = driver;
    }

    public AdminPostAddNewPO clickToAddNewButton() {
        waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
        return PageGeneratorManager.getAdminPostAddNewPage(driver);
    }

    public void enterToSearchTextbox(String postTitle) {
        waitForElementVisible(driver,AdminPostSearchPageUI.SEARCH_TEXTBOX );
        sendkeyToElement(driver,AdminPostSearchPageUI.SEARCH_TEXTBOX ,postTitle );
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_POST_BUTTON);
        clickToElement(driver, AdminPostSearchPageUI.SEARCH_POST_BUTTON);
    }

    public boolean isPostSearchTableDisplayed(String headerID, String cellValue) {
        int headerIndex = getElementSize(driver,AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME,headerID) + 1;
        waitForElementVisible(driver,AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX,String.valueOf(headerIndex),cellValue);
        return isElementDisplayed(driver,AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX,String.valueOf(headerIndex),cellValue);

    }

    public AdminPostAddNewPO clickToPostTitleLink(String postTitle) {
        waitForElementClickable(driver, AdminPostSearchPageUI.ROW_TITLE_DETAIL_BY_TITLE_NAME, postTitle);
        clickToElement(driver,AdminPostSearchPageUI.ROW_TITLE_DETAIL_BY_TITLE_NAME,postTitle);
        return PageGeneratorManager.getAdminPostAddNewPage(driver);

    }

    public void selectPostCheckboxByTitle(String editPostTitle) {
        waitForElementClickable(driver, AdminPostSearchPageUI.ROW_CHECKBOX_BY_TITLE_NAME, editPostTitle);
        checkToDefaultCheckbox(driver,AdminPostSearchPageUI.ROW_CHECKBOX_BY_TITLE_NAME,editPostTitle);
    }

    public void selectTextItemActionDropdown(String dropdownItem) {
        waitForElementClickable(driver, AdminPostSearchPageUI.ACTON_DROPDOWN);
        selectItemInDefaultDropdown(driver, AdminPostSearchPageUI.ACTON_DROPDOWN,dropdownItem);
    }

    public void clickToApplyButton() {
        waitForElementClickable(driver, AdminPostSearchPageUI.APPLY_BUTTON);
        clickToElement(driver,AdminPostSearchPageUI.APPLY_BUTTON);
    }

    public boolean isMoveToTrashMessageDisplayed(String message) {
        waitForElementClickable(driver, AdminPostSearchPageUI.MOVE_TO_TRASH_MESSAGE,message );
        return isElementDisplayed(driver, AdminPostSearchPageUI.MOVE_TO_TRASH_MESSAGE,message);
    }

    public boolean isNoPostFoundMessageDisplayed(String message) {
        waitForElementClickable(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE,message );
        return isElementDisplayed(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE,message);
    }
}
