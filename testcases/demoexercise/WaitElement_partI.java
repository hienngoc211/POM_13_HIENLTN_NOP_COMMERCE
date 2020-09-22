package demoexercise;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


		public class WaitElement_partI {
			
			WebDriver driver;
			WebDriverWait waitExplicit;
			By startBtnBy = By.xpath("//button[contains(text(),'Start')]");
			By loadingBarBy = By.xpath("//div[@id='loading']//img");
			By helloworldMsgBy = By.xpath("//h4[contains(text(),'Hello World!')]");
			
			
			
			
		@BeforeTest
 

			public void beforeClass() {
			
				System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
				driver = new FirefoxDriver();
				waitExplicit = new WebDriverWait(driver,10);
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
			
}
		
		
		@Test
		
		public void TC_01_Static() throws InterruptedException {
			driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
			driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]")).isDisplayed();
			Assert.assertEquals(driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]")).getText(), "Hello World!");		
			
		}
		
		@Test
		
		public void TC_02_ImplicitWait() {
			driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
//			check cho Start Button hiển thị 
			WebElement startBtn = driver.findElement(startBtnBy);
			Assert.assertTrue(startBtn.isDisplayed());
			startBtn.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			Loading icon hiển thị và mất tới 5s mới biến mất
//			Chờ cho Helloworld được hiển thị 
			WebElement helloWorld = driver.findElement(helloworldMsgBy);
			Assert.assertTrue(helloWorld.isDisplayed());				
		}
		
		@Test
		
		public void TC_03_Explicitwait_Visible() {
			driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
			waitExplicit.until(ExpectedConditions.elementToBeClickable(startBtnBy));
			driver.findElement(startBtnBy).click();
//			Loading icon hiển thị và biến mất 
//			Wait cho Helloworld được hiển thị 
			waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(helloworldMsgBy));
			
		}
		
		@Test 
		
		public void TC_04_ExplicitWait_Invisible() {
			driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
			waitExplicit.until(ExpectedConditions.elementToBeClickable(startBtnBy));
			driver.findElement(startBtnBy).click();
			System.out.println("S");
			waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(loadingBarBy));
			waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(helloworldMsgBy));
			
		}
		
		public String getCurrentTime() {
			Date date = new Date();
			return date.toString();
		}
		
		
		
		
		
		@AfterTest
		
		
		public void afterClass() {
			  driver.quit();
		  }
		}
		
		