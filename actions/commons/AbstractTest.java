package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class AbstractTest {
	private WebDriver driver;
	
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
	
}
