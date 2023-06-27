package pageObjects.wordpress;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.wordpress.AdminDashboardPageUI;
import pageUIs.wordpress.AdminUserPageUI;

public class AdminDashboardPO extends BasePage {
    WebDriver driver;
    public AdminDashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    public AdminPostSearchPO clickToPostMenuLink() {
        waitForElementClickable(driver, AdminDashboardPageUI.POST_MENU_LINK);
        clickToElement(driver, AdminDashboardPageUI.POST_MENU_LINK);
        return PageGeneratorManager.getAdminPostSearchPage(driver);
    }
    public AdminUserPO clickToUserMenuLink() {
        waitForElementClickable(driver, AdminUserPageUI.USER_MENU_LINK);
        clickToElement(driver, AdminUserPageUI.USER_MENU_LINK);
        return PageGeneratorManager.getAdminUserPage(driver);
    }
}
