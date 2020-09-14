package demoexercise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


			public class Topic10_User_Interaction {
			
			WebDriver driver;
			Actions action;
			JavascriptExecutor jsExecutor;
			WebDriverWait waitExplicit;
			
			
			
			
		@BeforeTest
 

			public void beforeClass() {
			
				System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
				driver = new FirefoxDriver();
				action = new Actions(driver);
				waitExplicit = new WebDriverWait(driver, 10);
				jsExecutor = (JavascriptExecutor) driver;
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
					
		}
			//@Test
		
			public void TC_01() throws InterruptedException {
			driver.get("https://www.myntra.com/");
			action.moveToElement(driver.findElement(By.xpath("//a[@class='desktop-main'][contains(text(),'Kids')]")));
			action.build().perform();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[contains(text(),'Home & Bath')]")).click();
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElement(By.xpath("//span[@class='breadcrumbs-crumb' and text()='Kids Home Bath']")).isDisplayed());
			
			
			
			
		}
		
			//@Test 
		
			public void TC_02_MoveandHold() throws InterruptedException {
			driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
			List <WebElement> numbers = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
			int numbersSize = numbers.size();
			System.out.println("Number before click:" + numbersSize);
			action.clickAndHold(numbers.get(0)).moveToElement(numbers.get(7)).release().perform();
			List<WebElement> selectedNumbers = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));
			Thread.sleep(2000);
			int selectedNumberSize = selectedNumbers.size();
			System.out.println("Number after click:" + selectedNumberSize);
			
			for (WebElement number: selectedNumbers) {
				System.out.println(number.getText());
			}
			
			Assert.assertEquals(selectedNumbers.size(), 8);
			
			driver.navigate().refresh();
			
			List <WebElement> numbers2 = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
			int numbers2Size = numbers2.size();
			System.out.println("Number2 before click: " + numbers2Size);
			
			action.keyDown(Keys.COMMAND).perform();
			action.click(numbers2.get(0))
			.click(numbers2.get(2))
			.click(numbers2.get(5))
			.click(numbers2.get(9))
			.perform();
			Thread.sleep(2000);
			action.keyUp(Keys.COMMAND).perform();
			List<WebElement> selectedNumbers2 = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));
			int selectedNumbers2Size = selectedNumbers2.size();
			System.out.println("Numbers after click random is: " + selectedNumbers2Size);
			for (WebElement selectednumber : selectedNumbers2) {
				System.out.println(selectednumber.getText());
				
			}
			Assert.assertEquals(selectedNumbers2.size(), 4);
			
			
		}
		
			@Test
	
			public void TC_03_doubleClick() throws InterruptedException {

			driver.get("https://automationfc.github.io/basic-form/index.html");
			String doubleClickBtn = "//button[contains(text(),'Double click me')]";
			jsScrolltoElement(doubleClickBtn);
			Thread.sleep(2000);
			//waitExplicit.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(doubleClickBtn))));
			action.doubleClick(driver.findElement(By.xpath(doubleClickBtn)));
			action.build().perform();
			Thread.sleep(2000);
			String textMessage = driver.findElement(By.xpath("//p[@id='demo']")).getText();
			Assert.assertEquals(textMessage, "Hello Automation Guys!");
	}
		
			
		@AfterTest
		
		public void afterClass() {
			  driver.quit();
		  }
		
			
			 public void jsScrolltoElement(String locator) {
				  WebElement element = driver.findElement(By.xpath(locator));
				 jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
			 }
			}			
		
		