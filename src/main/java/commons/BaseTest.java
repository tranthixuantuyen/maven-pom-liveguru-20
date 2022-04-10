package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driverBaseTest;
	String projectLocaion = System.getProperty("user.dir");
	
	protected WebDriver getBrowserDriver(String browserName) {

		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driverBaseTest = new FirefoxDriver();
			
		} else if (browserName.equals("h_firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new FirefoxDriver(options);
			
		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driverBaseTest = new ChromeDriver();
			
		} else if (browserName.equals("h_chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1366x768");
			driverBaseTest = new ChromeDriver(options);
			
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();
			
		} else if (browserName.equals("coccoc")) {
			// CocCoc browser subtract 5-6 version chromedriver
			WebDriverManager.chromedriver().driverVersion("93.0.4577.63").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driverBaseTest = new ChromeDriver(options);
			
		} else {
			throw new RuntimeException("Browser name invalid.");
		}
		
		driverBaseTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driverBaseTest.get("https://demo.nopcommerce.com/");
		return driverBaseTest;

	}
	
	
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			System.out.print(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			System.out.print(" -------------------------- FAILED -------------------------- ");
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			System.out.print(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			System.out.print(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			System.out.print(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			System.out.print(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	} 
}
