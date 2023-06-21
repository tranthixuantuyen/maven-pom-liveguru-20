package pageObjects.saurcelab;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.saurcelab.LoginPageUI;

public class LoginPO extends BasePage {
    WebDriver driver;
    public LoginPO(WebDriver driver){
        this.driver = driver;
    }

    public void enterToUsernameTextbox(String username) {
        waitForAllElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX,username );

    }

    public void enterToPasswordTextbox(String password) {
        waitForAllElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX,password );
    }

    public ProductPO clickToLoginButton() {
        waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
        return PageGenaratorManager.getProductPO(driver);
    }
}
