package demoexercise;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


		public class Topic14_JSExecuter {
			
			WebDriver driver;
			JavascriptExecutor jsExecutor;
			By userID = By.xpath("//input[@name='uid']");
			By loginBtn = By.xpath("//input[@name='btnLogin']");
			By passwordLogin = By.xpath("//input[@name='password']");
			By newCustomerBtn = By.xpath("//a[contains(text(),'New Customer')]");
			String user = "mngr26593";
			String pw = "ishal!12";
			By customerName = By.name("name");
			By genderRadioBtn = By.xpath("//input[@value='f']");
			By dateOfBirth = By.xpath("//input[@id='dob']");
			By address = By.name("addr");
			By citytxb = By.xpath("//input[@name='city']");
			By statetxb = By.xpath("//input[@name='state']");
			By pintxb = By.xpath("//input[@name='pinno']");
			By mobileNumbertxb = By.xpath("//input[@name='telephoneno']");
			By emailtxb = By.xpath("//input[@name='emailid']");
			By passwordtxb = By.xpath("//input[@name='password']");
			By submitBtn = By.name("sub");
			String name = "Barac";
			String dob = "07/08/1988";
			String add = "56 Phan Chau Trinh";
			String city = "Da Nang";
			String state = "Hai Chau";
			String pin = "456789";
			String mobileNumber = "0976543123";
			String email = "ahihi" + randomNumber() + "@gmail.com";
			String password = "123456ghj";
			

			
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
		
//		@Test
			public void TC_02() throws InterruptedException {
				navigateToUrlByJS("http://demo.guru99.com/v4");
				sendkeyToElementByJS(userID, user);
				Thread.sleep(2000);
				sendkeyToElementByJS(passwordLogin, pw);
				Thread.sleep(2000);			
				clickToElementByJS(loginBtn);
				Thread.sleep(2000);	
				clickToElementByJS(newCustomerBtn);
				Thread.sleep(5000);			
				sendKeyToElement(customerName, name);
				Thread.sleep(2000);			
				clickToElementByJS(genderRadioBtn);
				Thread.sleep(2000);			
				removeAttributeInDOM(dateOfBirth,"type");
				Thread.sleep(2000);	
				sendKeyToElement(dateOfBirth, dob);
				Thread.sleep(2000);	
				sendKeyToElement(address, add);
				Thread.sleep(5000);	
				sendKeyToElement(citytxb, city);
				Thread.sleep(2000);	
				sendKeyToElement(statetxb, state);
				Thread.sleep(2000);	
				sendKeyToElement(pintxb, pin);
				Thread.sleep(2000);	
				sendKeyToElement(mobileNumbertxb, mobileNumber);
				Thread.sleep(2000);	
				sendKeyToElement(emailtxb, email);
				Thread.sleep(2000);	
				sendKeyToElement(passwordtxb, password);
				Thread.sleep(2000);	
				clickToElementByJS(submitBtn);	
				Thread.sleep(5000);	
			Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Customer Name')]/following-sibling::td")).getText(), name );
		}
	@Test 
	
	public void TC_03_Create_an_Account() {
		navigateToUrlByJS("http://live.demoguru99.com/");
		By myAccount = By.xpath("//div[@id='header-account']//child::a[@title='My Account']");
		clickToElementByJS(myAccount);
		By createAnAccountBtn = By.xpath("//a[@title='Create an Account']");
		clickToElementByJS(createAnAccountBtn);
		By firstNameTxb = By.xpath("//input[@id='firstname']");
		By lastNameTxb = By.xpath("//input[@id='lastname']");
		By emailTxb = By.xpath("//input[@id='email_address']");
		By passwordTxb = By.xpath("//input[@id='password']");
		By confirmpassTxb = By.xpath("//input[@id='confirmation']");
		By registerBtn = By.xpath("//button[@title='Register']");
		String firstName = "Automation";
		String lastName = "QA";
		String email = "automation" + randomNumber() + "@hotmail.com";
		String password = "123asd456";
		sendkeyToElementByJS(firstNameTxb, firstName);
		sendkeyToElementByJS(lastNameTxb, lastName);
		sendkeyToElementByJS(emailTxb, email);
		sendkeyToElementByJS(passwordTxb, password);
		sendkeyToElementByJS(confirmpassTxb, password);
		clickToElementByJS(registerBtn);
		String successMsg = driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText();
		Assert.assertEquals(successMsg, "Thank you for registering with Main Website Store.");
		System.out.println("Success Msg is: " + successMsg);
		By logOutBtn = By.xpath("//a[@title='Log Out']");
		clickToElementByJS(logOutBtn);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title']")).isDisplayed());

		
		
		
		
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

//	Element
		
		public void clickToElementByJS(By by) {
			WebElement element = driver.findElement(by);
			jsExecutor.executeScript("arguments[0].click();", element);
		}

		public void scrollToElement(WebElement element) {
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		}

		public void sendkeyToElementByJS(By by, String value) {
			WebElement element = driver.findElement(by);
			jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
		}

		public void removeAttributeInDOM(By by, String attributeRemove) {
			WebElement element = driver.findElement(by);
			jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
		}
		
		public void sendKeyToElement(By by, String value) {
			WebElement element = driver.findElement(by);
			element.sendKeys(value );
		}
		public int randomNumber() {
			Random rand = new Random();
			return rand.nextInt(100000);
		}
		
		
		}
		
		