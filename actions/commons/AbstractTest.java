package commons;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

public class AbstractTest {
	private WebDriver driver;
	protected final Log log;
	public AbstractTest() {
		log = LogFactory.getLog(getClass());
	}
	
	public WebDriver getBrowserDriver(String browserName) {
	if (browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver");
		driver = new ChromeDriver();
			
	} else if (browserName.equalsIgnoreCase("firefox")){
		System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
		driver = new FirefoxDriver();
		
	} else if (browserName.equalsIgnoreCase("headless_chrome")) {
		System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver");
		driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1920x1080");
		driver = new ChromeDriver(options);
		
	} else if (browserName.equalsIgnoreCase("headless_firefox")) {
		System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
		driver = new FirefoxDriver();
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		options.addArguments("window-size=1920x1080");
		driver = new FirefoxDriver(options);
	}

	//driver = new FirefoxDriver();
	driver.get(GlobalConstants.DEV_URL);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	System.out.println("Abstractest = " + driver.toString());
	return driver;
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
