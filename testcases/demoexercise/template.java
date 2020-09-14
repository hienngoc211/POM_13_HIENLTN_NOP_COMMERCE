package demoexercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


		public class template {
			
			WebDriver driver;
			
			
			
			
			
		@BeforeTest
 

			public void beforeClass() {
			
				System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
			
}
		
		
		@Test
		
		public void TC_01() {
			
			
		}
		
		
		
		@AfterTest
		
		
		public void afterClass() {
			  driver.quit();
		  }
		}
		
		