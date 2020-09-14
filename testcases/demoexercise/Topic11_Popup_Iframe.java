package demoexercise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


		public class Topic11_Popup_Iframe {
			
			WebDriver driver;
			WebDriverWait waitExplicit;
			JavascriptExecutor javaScript;
			Actions action;
			
			
			
		@BeforeTest
 

			public void beforeClass() {
			
				System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("dom.webnotifications.enabled", false);
				driver = new FirefoxDriver();
				waitExplicit = new WebDriverWait(driver, 10);
				action = new Actions(driver);
				javaScript = (JavascriptExecutor) driver;
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
			
}
		
		
		//@Test
		
		public void TC_01_popup() throws InterruptedException {
			driver.get("https://www.zingpoll.com/");
			driver.findElement(By.xpath("//a[@id='Loginform']")).click();
			Thread.sleep(5000);
			List <WebElement> popup = driver.findElements(By.xpath("//div[@class='modal-dialog modal_dialog_custom']//div[@class='modal-content']"));
			if (popup.size()>0) {
				
				Assert.assertTrue(popup.get(0).isDisplayed());
				driver.findElement(By.xpath("//div[@class='modal-dialog modal_dialog_custom']//span[contains(text(),'×')]")).click();
				Assert.assertFalse(popup.get(0).isDisplayed());
				System.out.println("Pop up is disable");
			}
			
		}
		
		//@Test 
		
		public void TC_02_Popup2 () {
			driver.get("https://bni.vn/");
			List <WebElement> dialogpopup = driver.findElements(By.xpath("//div[@id='sgpb-popup-dialog-main-div']"));
			if (dialogpopup.size()>0) {
				Assert.assertTrue(dialogpopup.get(0).isDisplayed());
				waitExplicit.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Close']")));
				driver.findElement(By.xpath("//img[@alt='Close']")).click();
			}
		}
		
		//@Test 
		
		public void TC_03_Popup3 () throws InterruptedException {
			driver.get("https://blog.testproject.io/");
			Thread.sleep(7000);
			waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='mailch-wrap rocket-lazyload']")));
			List<WebElement> solutionpopup = driver.findElements(By.xpath("//div[@class='mailch-wrap rocket-lazyload']"));
			if (solutionpopup.size()>0) {
				Assert.assertTrue(solutionpopup.get(0).isDisplayed());
				waitExplicit.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='close-mailch']")));
				driver.findElement(By.xpath("//div[@id='close-mailch']")).click();
				driver.findElement(By.xpath("//section[@id='search-2']//input[@placeholder='Search Articles']")).sendKeys("Selenium");
				Thread.sleep(3000);
			}
			driver.findElement(By.xpath("//section[@id='search-2']//span[@class='glass']")).click();
			Thread.sleep(3000);
			 List<WebElement> textSelenium = driver.findElements(By.xpath("//h3[@class='post-title']"));
			 for ( WebElement text : textSelenium) {
				 if (text.getText().contains("Selenium"))
				 {
					 System.out.println("Title có chứa text Selenium: " + text.getText());
				 }
				 
			 }
		}
		
		@Test
		
		public void TC_04_Iframe() throws InterruptedException {
			
			driver.get("https://kyna.vn/");
			
			waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@class='fancybox-image']")));
			List<WebElement> fancypopup = driver.findElements(By.xpath("//img[@class='fancybox-image']"));
			if(fancypopup.size()>0) {
				Assert.assertTrue(fancypopup.get(0).isDisplayed());
				waitExplicit.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@title='Close']"))));
				driver.findElement(By.xpath("//a[@title='Close']")).click();
			}
			jsScrolltoElement(("//div[contains(@class,'fanpage')]//iframe"));
			driver.switchTo().frame(driver.findElement(By.xpath("//div[contains(@class,'fanpage')]//iframe")));
			Thread.sleep(5000);
			boolean facebookIframe = driver.findElement(By.cssSelector("#facebook")).isDisplayed();
			System.out.println("Facebook iframe displayed = " + facebookIframe);
			Assert.assertTrue(facebookIframe);
			
			String likeNumber = driver.findElement(By.xpath("//a[@title='Kyna.vn']/parent::div//following-sibling::div")).getText();
			System.out.println("Like number is: " + likeNumber);
			Assert.assertEquals(likeNumber,"169K likes");
			
			driver.switchTo().defaultContent();
			//waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='container']//div[@class='meshim_widget_widgets_ViewStack']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='cs_chat_iframe']")));
			Thread.sleep(2000);
			action.sendKeys(driver.findElement(By.xpath("//textarea[@placeholder='Hãy nhập tin nhắn để chat']")), "question").sendKeys(Keys.ENTER);
			action.build().perform();
			Thread.sleep(3000);
			String profileSection = "//div[@class='meshim_widget_widgets_menu_Section flow desktop']/parent::div/following-sibling::form";
			driver.findElement(By.xpath(profileSection)).isDisplayed();
			System.out.println("Profile section is display " + profileSection);
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//input[@id='live-search-bar']")).sendKeys("Java");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='search-button']//img")).click();
			List<WebElement> textsJava = driver.findElements(By.xpath("//a[@class='card-popup']"));
			for (WebElement textJava: textsJava) {
				if (textJava.getText().contains("Java"));
				System.out.println("Các khoá học Java là: " + textJava);
			}
		
		}
	
		
		@AfterTest
		
		
		public void afterClass() {
			  driver.quit();
		  }
		
		public void jsScrolltoElement (String locator) {
			WebElement element = driver.findElement(By.xpath(locator));
			javaScript.executeScript("arguments[0].scrollIntoView(true);", element);

		}
		}
		
		