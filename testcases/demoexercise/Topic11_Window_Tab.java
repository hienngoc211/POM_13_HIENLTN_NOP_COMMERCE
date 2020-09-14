package demoexercise;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


		public class Topic11_Window_Tab {
			
			WebDriver driver;
			JavascriptExecutor javaScript;
			WebDriverWait waitExplicit;
			Alert alert;
		@BeforeTest
 

			public void beforeClass() {
			
				System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
				driver = new FirefoxDriver();
				javaScript = (JavascriptExecutor) driver;
				waitExplicit = new WebDriverWait(driver, 10);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
			
}
		
		
		//@Test
		
		public void TC_01_Window() throws InterruptedException {
			
			driver.get("https://automationfc.github.io/basic-form/index.html");
			String parentID = driver.getWindowHandle();
			System.out.println("Parent ID = " + parentID);
			String googleText = "//a[contains(text(),'GOOGLE')]";
			jsSrollToElement(googleText);
			Thread.sleep(2000);
			clickToElement(googleText);
			Thread.sleep(2000);
			switchToWindowID(parentID);
			Thread.sleep(3000);
			Assert.assertEquals(driver.getTitle(), "Google");
			driver.switchTo().window(parentID);
			Thread.sleep(2000);
			String facebookText = "//a[contains(text(),'FACEBOOK')]";
			clickToElement(facebookText);
			Thread.sleep(2000);
			switchToWindowByTitle("Facebook - Đăng nhập hoặc đăng ký");
			Thread.sleep(3000);
			Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
			Thread.sleep(2000);
			driver.switchTo().window(parentID);
			Thread.sleep(2000);
			String tikiText = "//a[contains(text(),'TIKI')]";
			clickToElement(tikiText);
			Thread.sleep(2000);
			switchToWindowByTitle("Mua Hàng Trực Tuyến Uy Tín với Giá Rẻ Hơn tại Tiki.vn");
			Thread.sleep(2000);
			Assert.assertEquals(driver.getTitle(), "Mua Hàng Trực Tuyến Uy Tín với Giá Rẻ Hơn tại Tiki.vn");
			closeAllWindowWithoutParent(parentID);
			Thread.sleep(2000);
			Assert.assertEquals(driver.getTitle(), "SELENIUM WEBDRIVER FORM DEMO");

		}	
		
//		@Test
		
		public void TC_02_Tab () throws InterruptedException {
			driver.get("https://kyna.vn/");
			String parentID = driver.getWindowHandle();
			System.out.println("Parent ID = " + parentID);
			List<WebElement> fancypopup = driver.findElements(By.xpath("//img[@class='fancybox-image']"));
			Thread.sleep(3000);
			if (fancypopup.size()>0) {
				Assert.assertTrue(fancypopup.get(0).isDisplayed());
				driver.findElement(By.xpath("//a[@class='fancybox-item fancybox-close']")).click();
			}
			//Thread.sleep(2000);
			//jsSrollToElement("//img[@alt='facebook']");
			Thread.sleep(2000);
			clickToElementByJS("//img[@alt='facebook']");
			Thread.sleep(2000);
			switchToWindowByTitle("Kyna.vn | Facebook");
			Thread.sleep(2000);
			Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/kyna.vn");
			Thread.sleep(2000);
			switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
			Thread.sleep(2000);
			//jsSrollToElement("//div[@class='social']//a/img[@alt='youtube']");
			//Thread.sleep(2000);
			clickToElementByJS("//div[@class='social']//a[@href='https://www.youtube.com/user/kynavn']");
			Thread.sleep(6000);
			switchToWindowByTitle("Kyna.vn - YouTube");
			Thread.sleep(6000);
			Assert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/user/kynavn");
			Thread.sleep(3000);
			switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
			Thread.sleep(3000);
			clickToElementByJS("//div[@class='social']//img[@alt='zalo']");
			Thread.sleep(6000);
			switchToWindowByTitle("Kyna.vn");
			Thread.sleep(3000);
			Assert.assertEquals(driver.getCurrentUrl(), "https://zalo.me/1985686830006307471");
			Thread.sleep(3000);
			switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
			Thread.sleep(3000);
			clickToElementByJS("//div[@class='icon-app']/a[@title='Android']");
			Thread.sleep(6000);
			switchToWindowByTitle("Kyna.vn Official – Học Online cùng chuyên gia - Apps on Google Play");
			Thread.sleep(9000);
			Assert.assertEquals(driver.getCurrentUrl(), "https://play.google.com/store/apps/details?id=com.navikyna");
			Thread.sleep(9000);
			switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
			closeAllWindowWithoutParent(parentID);
			Thread.sleep(3000);
			driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='face-content']//iframe")));
			Thread.sleep(3000);
			boolean facebookIframe = driver.findElement(By.cssSelector("#facebook")).isDisplayed();
			System.out.println("Facebook iframe displayed = " + facebookIframe);
			Assert.assertTrue(facebookIframe);
			switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
			Thread.sleep(3000);
		}
		
		@Test
		
		public void TC_03() throws InterruptedException {
			driver.get("http://live.demoguru99.com/index.php/");
			String mobileBtn = "//a[contains(text(),'Mobile')]";
			clickToElement(mobileBtn);
			String SonyAddToCompare = "//a[@title='Sony Xperia']//parent::h2//following-sibling::div[@class='actions']//descendant::li/a[contains(text(),'Add to Compare')]";
			clickToElement(SonyAddToCompare);
			Thread.sleep(2000);
			String SuccessMsg = driver.findElement(By.xpath("//span[contains(text(),'The product Sony Xperia has been added to comparis')]")).getText();
			Assert.assertEquals(SuccessMsg, "The product Sony Xperia has been added to comparison list.");
			String SamsungAddToCompare = "//a[@title='Samsung Galaxy']//parent::h2//following-sibling::div[@class='actions']//descendant::li/a[contains(text(),'Add to Compare')]";
			clickToElement(SamsungAddToCompare);
			String SuccessMsg3 = driver.findElement(By.xpath("//span[contains(text(),'The product Samsung Galaxy has been added to comparis')]")).getText();
			Assert.assertEquals(SuccessMsg3, "The product Samsung Galaxy has been added to comparison list.");
			String compareBtn = "//div[@class='actions']//span//span[contains(text(),'Compare')]";
			clickToElement(compareBtn);
			String parentID = driver.getWindowHandle();
			switchToWindowByTitle("Products Comparison List - Magento Commerce");
			Thread.sleep(2000);
			Assert.assertEquals(driver.getTitle(), "Products Comparison List - Magento Commerce");
			System.out.println("Title is: " + driver.getTitle());
			closeAllWindowWithoutParent(parentID);
			Thread.sleep(2000);
			String clearAllBtn = "//a[contains(text(),'Clear All')]";
			clickToElement(clearAllBtn);
			Thread.sleep(2000);
			alert = driver.switchTo().alert();
			alert.accept();
			Thread.sleep(2000);
			String SuccessMsg4 = driver.findElement(By.xpath("//span[contains(text(),'The comparison list was cleared.')]")).getText();
			Assert.assertEquals(SuccessMsg4, "The comparison list was cleared.");
			System.out.println("SuccessMsg4 = " + SuccessMsg4);
		}
			
	
		@AfterTest
		public void afterClass() {
			driver.quit();
		  }
		
		
		public void clickToElement(String locator) {
			WebElement element = driver.findElement(By.xpath(locator));
			element.click();
	
		}
		public void jsSrollToElement(String locator) {
			WebElement element = driver.findElement(By.xpath(locator));
			javaScript.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		
		
		public void switchToWindowID(String parentID) {
			Set<String> allWindowID = driver.getWindowHandles();
			for (String termID : allWindowID) {
				if (!termID.equals(parentID)) {
					driver.switchTo().window(termID);
					break;
				}
			}
		}
		
		public void switchToWindowByTitle(String expectedtitle) {
			Set<String> allWindow = driver.getWindowHandles();
			for (String termID : allWindow) {
				driver.switchTo().window(termID);
				String currentTitle = driver.getTitle();
				if (currentTitle.equals(expectedtitle)) {
					break;
				}
			}
		}
		
		public void closeAllWindowWithoutParent(String parentID) {
			Set<String> allWindow = driver.getWindowHandles();
			for (String runWindows : allWindow) {
				if (!runWindows.equals(parentID)) {
					driver.switchTo().window(runWindows);
					driver.close();
				}
				driver.switchTo().window(parentID);
				
			}
				
		}
		
		public void clickToElementByJS(String locator) {
			WebElement element = driver.findElement(By.xpath(locator));
			javaScript.executeScript("arguments[0].click();", element);
		}
		
		}
		
		
	
		
		
		