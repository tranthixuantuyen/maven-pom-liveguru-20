package pageFactory.nopCommerce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.GlobalConstants;

public class BasePageFactory {
	
	public static BasePageFactory getBasePageObject() {
		return new BasePageFactory();
		
	}

	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}


	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}


	public String getTextAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {

		waitForAlertPresence(driver).sendKeys(value);
	}


	private WebElement getElement(WebDriver driver, String locator) {

		return driver.findElement(getByXpath(locator));
	}


	private By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	
	public String getElementAttribute(WebDriver driver, WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	public void sendkeyToElement(WebDriver driver, WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void sleepInMilisecond(long milisecond) {
		try {
			Thread.sleep(milisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}


	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}


	public boolean isElementEnable(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}


	public void waitForElementVisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForAllElementVisible(WebDriver driver, List<WebElement> elements) {
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}


	public void waitForElementInvisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitForAllElementInvisible(WebDriver driver, List<WebElement> elements) {
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}

	public void waitToElementPresence(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(locator)));
	}

	public void waitToElementNumberToBe(WebDriver driver, String locator, int number) {
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		explicitWait.until(ExpectedConditions.numberOfElementsToBe(getByXpath(locator), number));
	}

	public void waitForElementClickable(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	private WebDriverWait explicitWait;
}
