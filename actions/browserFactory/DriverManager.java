package browserFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	
	
	public WebDriver driver;

		abstract void createDriver ();
		public void quitBrowserDriver() {
			if (driver != null) {
				driver.quit();
				driver = null ;
			}
			
			
		}
		
		public WebDriver getDriverBrowser () {
			if (driver == null) {
			createDriver ();
			driver.get("http://demo.nopcommerce.com/");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		    return driver;
		}
}
