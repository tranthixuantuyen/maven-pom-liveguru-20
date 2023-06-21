package pageObjects.saurcelab;

import org.openqa.selenium.WebDriver;

public class PageGenaratorManager {
    WebDriver driver;
    public PageGenaratorManager(WebDriver driver){
        this.driver = driver;
    }

    public static LoginPO getLoginPO (WebDriver driver){
        return new LoginPO(driver);
    }

    public static ProductPO getProductPO (WebDriver driver){
        return new ProductPO(driver);
    }
}
