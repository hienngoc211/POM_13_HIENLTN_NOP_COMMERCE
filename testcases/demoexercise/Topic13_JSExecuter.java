package demoexercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


		public class Topic13_JSExecuter {
			
			WebDriver driver;
			JavascriptExecutor jsExecutor;
			
			
			
		@BeforeTest
 

			public void beforeClass() {
			
//				System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
//				driver = new FirefoxDriver();
				System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver");
			
				driver = new ChromeDriver();
				
				jsExecutor = (JavascriptExecutor) driver;
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
			
}
		
		
//		@Test
		
		public void TC_01() throws InterruptedException {
			
			navigateToUrlByJS("http://live.demoguru99.com/");
			Thread.sleep(3000);
			String liveDomain =  (String) executeForBrowser("return document.domain");
			Thread.sleep(2000);
			Assert.assertEquals(liveDomain, "live.demoguru99.com");
			String liveUrl = (String) executeForBrowser("return document.URL");
			Assert.assertEquals(liveUrl, "http://live.demoguru99.com/");
			Thread.sleep(2000);
			By mobileBtn = By.xpath("//a[contains(text(),'Mobile')]");
			clickToElementByJS(mobileBtn);
			Thread.sleep(2000);
			String mobileText = driver.findElement(By.xpath("//h1[contains(text(),'Mobile')]")).getText();
			Assert.assertEquals(mobileText, "MOBILE");
			Thread.sleep(2000);
			By addCartBtn = By.xpath("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/child::button[@title='Add to Cart']");
			clickToElementByJS(addCartBtn);
			Thread.sleep(2000);
			String pageInnerText = (String) executeForBrowser("return document.documentElement.innerText");
			Assert.assertTrue(pageInnerText.contains("Samsung Galaxy was added to your shopping cart."));
			Thread.sleep(2000);
			By customerBtn = By.xpath("//a[contains(text(),'Customer Service')]");
			clickToElementByJS(customerBtn);
			Thread.sleep(2000);
			Assert.assertEquals(driver.getTitle(), "Customer Service");
			Thread.sleep(2000);
			By newletterTxtbox = By.xpath("//input[@type='email']");
			scrollToBottomPage(newletterTxtbox);
			Thread.sleep(2000);
			String bottomInnerText = (String) executeForBrowser("return document.documentElement.innerText");
			Assert.assertTrue(bottomInnerText.contains("Praesent ipsum libero, auctor ac, tempus nec, tempor nec, justo."));
			Thread.sleep(2000);
			navigateToUrlByJS("http://demo.guru99.com/v4/");
			Thread.sleep(2000);
			Assert.assertEquals(driver.getCurrentUrl(), "http://demo.guru99.com/v4/");
			Thread.sleep(2000);

		}
		
		@Test
			public void TC_02() throws InterruptedException {
				driver.get("http://demo.guru99.com/v4");
				WebElement userIDtxb = driver.findElement(By.xpath("//input[@name='uid']"));
				String userID = "mngr276926";
				WebElement passwordtxb = driver.findElement(By.xpath("//input[@name='password']"));
				String password = "EdasEru";
				sendkeyToElementByJS(userIDtxb, userID);
				Thread.sleep(2000);
				sendkeyToElementByJS(passwordtxb, password);
				Thread.sleep(2000);
				By loginBtn = By.xpath("//input[@name='btnLogin']");
				Thread.sleep(2000);
				clickToElementByJS(loginBtn);
		}
		
		
		@AfterTest
		
		
		public void afterClass() {
			  driver.quit();
		  }
		
//		Browser
		
		public Object executeForBrowser(String javaScript) {

			return jsExecutor.executeScript(javaScript);
		}
		
		public boolean verifyTextInInnerText(String textExpected) {
			String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
			return textActual.equals(textExpected);
		}
		public void scrollToBottomPage(By by) {
			jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		}

		public void navigateToUrlByJS(String url) {
			jsExecutor.executeScript("window.location = '" + url + "'");
		}

		public void highlightElement(WebElement element) {
			String originalStyle = element.getAttribute("style");
			jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
//			sleepInSecond(1);
			jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);

		}

//		Element
		
		public void clickToElementByJS(By by) {
			WebElement element = driver.findElement(by);
			jsExecutor.executeScript("arguments[0].click();", element);
		}

		public void scrollToElement(WebElement element) {
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		}

		public void sendkeyToElementByJS(WebElement element, String value) {
			jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
		}

		public void removeAttributeInDOM(WebElement element, String attributeRemove) {
			jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
		}
		
		
		
		}
		
		