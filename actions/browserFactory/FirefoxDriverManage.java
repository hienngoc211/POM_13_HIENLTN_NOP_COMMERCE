package browserFactory;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManage extends DriverManager{

	@Override
	void createDriver() {
		System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
		driver = new FirefoxDriver();
	
	}

}
