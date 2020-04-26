package browserFactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManage extends DriverManager {

	@Override
	void createDriver() {
		// Add service and new driver
		System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		
	}
	
	

}
