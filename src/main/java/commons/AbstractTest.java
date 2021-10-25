package commons;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {
	private WebDriver driver;
	private String projectFolder = System.getProperty("user.dir");
	private String osName = System.getProperty("user.dir");
	
	protected final Log log;
	
	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}
	
	protected WebDriver getBrowserDriver(String browserName) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		
		 //if(browserName.equals("firefox_ui")) 
		if(browser == Browser.FIREFOX_UI){
			WebDriverManager.firefoxdriver().setup();
			//Ho tro chay co dinh 1 version
			//WebDriverManager.firefoxdriver().browserVersion("87.0").setup();
			driver = new FirefoxDriver();
			
		} else if(browser == Browser.FIREFOX_HEADLESS) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);
			
		} else if(browser == Browser.CHROME_UI) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver = new ChromeDriver(options);
			
		} else if(browser == Browser.CHROME_HEADLESS) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1366x768");
			driver = new ChromeDriver(options);
			
		} else if(browser == Browser.EDGE_CHROMIUM) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please input valid browser name value!");
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String url) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		
		if(browser == Browser.FIREFOX_UI){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else if(browser == Browser.FIREFOX_HEADLESS) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);
			
		} else if(browser == Browser.CHROME_UI) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver = new ChromeDriver(options);
			
		} else if(browser == Browser.CHROME_HEADLESS) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1366x768");
			driver = new ChromeDriver(options);
			
		} else if(browser == Browser.EDGE_CHROMIUM) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please input valid browser name value!");
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	
	private void setBrowserDriverProperty() {
		String browserFolderPath = projectFolder + getDirectorySlash("browserDrivers");
		if (isWindows()) {
			System.setProperty("webdriver.gecko.driver", browserFolderPath + "geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", browserFolderPath + "chromedriver.exe");
			System.setProperty("webdriver.edge.driver", browserFolderPath + "msedgedriver.exe");
		} else if (isMac()) {
			System.setProperty("webdriver.gecko.driver", browserFolderPath + "geckodriver_mac");
			System.setProperty("webdriver.chrome.driver", browserFolderPath + "chromedriver_mac");
			System.setProperty("webdriver.edge.driver", browserFolderPath + "msedgedriver_mac");
		} else {
			System.setProperty("webdriver.gecko.driver", browserFolderPath + "geckodriver_linux");
			System.setProperty("webdriver.chrome.driver", browserFolderPath + "chromedriver_linux");
		}
	}
	
	protected int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
	
	private String getDirectorySlash(String folderName) {
		if (isMac() || isUnix() || isSolaris()) {
			folderName = "/" + folderName + "/";
		} else if (isWindows()) {
			folderName = "\\" + folderName + "\\";
		} else {
			folderName = null;
		}
		return folderName;
	}

	private boolean isWindows() {
		return (osName.toLowerCase().indexOf("win") >= 0);
	}

	private boolean isMac() {
		return (osName.toLowerCase().indexOf("mac") >= 0);
	}

	private boolean isUnix() {
		return (osName.toLowerCase().indexOf("nix") >= 0 || osName.toLowerCase().indexOf("nux") >= 0);
	}

	private boolean isSolaris() {
		return (osName.toLowerCase().indexOf("sunos") >= 0);
	}
	
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

}
