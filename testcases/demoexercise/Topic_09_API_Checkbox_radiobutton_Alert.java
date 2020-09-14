package demoexercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


		public class Topic_09_API_Checkbox_radiobutton_Alert {
			
			WebDriver driver;
			JavascriptExecutor javascript;
			Alert alert;
			By phoneTextbox = By.xpath("//input[@id='login_username']");
			By passwordTextbox = By.xpath("//input[@id='login_password']");
			String phonenumber = "0932725724";
			String password = "123abc";
			String fullName = "automation";
			String resultMessage = "//p[@id='result']";
		@BeforeTest
 

			public void beforeClass() {
			
				System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
				driver = new FirefoxDriver();
				javascript = (JavascriptExecutor) driver;
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
			
}
	
		
		//@Test
	
		public void TC_01() {
			driver.get("https://automationfc.github.io/basic-form/index.html");
			elementEnableStatus("//button[@id='button-enabled']");
			
			elementEnableStatus("//input[@id='development']");
			elementSelectedStatus("//input[@id='under_18']");
			
		}
		
		//@Test 
		
		public void clickByJS() throws InterruptedException {



			driver.get("https://demo.nopcommerce.com/");
			javascript.executeScript("arguments[0].click();", driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Desktops')]")));
			Thread.sleep(3000);
			Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Desktops')]")).isDisplayed());
		}
		 
		//@Test
		
		public void TC_02_Button() throws InterruptedException {

			driver.get("https://www.fahasa.com/customer/account/create");
			driver.findElement(By.xpath("//div[@class='fhs_top_account_login_button']//div[contains(text(),'ng nh')]")).click();
			elementEnableStatus("//button[@class='fhs-btn-login']");
			Thread.sleep(3000);
			
			sendKeyToElement(phoneTextbox, phonenumber);
			sendKeyToElement(passwordTextbox, password);
			
			elementEnableStatus("//button[@class='fhs-btn-login']");
			Thread.sleep(2000);
			
			driver.navigate().refresh();
			
			driver.findElement(By.xpath("//div[@class='fhs_top_account_login_button']")).click();
			
			removeAttributeInDOM("//button[@class='fhs-btn-login']", "disabled");
			Thread.sleep(2000);
			
			
			
		}
		
		//@Test
		 
		
		public void TC_03_Checkbox() {



			driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
			String checkbox = "//input[@id='eq5']";
			driver.findElement(By.xpath(checkbox)).click();
			elementSelectedStatus(checkbox);
			uncheckToCheckbox(checkbox);
			elementSelectedStatus(checkbox);
			
			driver.navigate();
			driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
			String radio = "//input[@id='engine3']";
			Assert.assertFalse(isElementSelected(radio));
			driver.findElement(By.xpath(radio)).click();
			isElementSelected(radio);
		
		}
		
		//@Test
		
		public void TC_04_Custom_Checkbox_Radio() throws InterruptedException {




			driver.get("https://material.angular.io/components/radio/examples");
			String summerRadioBtn = "//mat-radio-button[@id='mat-radio-4']//div[@class='mat-radio-outer-circle']";
			Assert.assertFalse(isElementSelected(summerRadioBtn));
			clickToElementByJS(summerRadioBtn);
			Thread.sleep(2000);
			
			driver.navigate();
			driver.get("https://material.angular.io/components/checkbox/examples");
			String checkboxChecked = "//mat-checkbox[@id='mat-checkbox-1']//div[@class='mat-checkbox-inner-container']";
			String checkboxIndeterminate = "//mat-checkbox[@id='mat-checkbox-2']//div[@class='mat-checkbox-inner-container']";
			clickToElementByJS(checkboxChecked);
			Thread.sleep(2000);
			clickToElementByJS(checkboxIndeterminate);
			Thread.sleep(2000);
			clickToElementByJS(checkboxChecked);
			Thread.sleep(2000);
			clickToElementByJS(checkboxIndeterminate);
			Thread.sleep(2000);
			Assert.assertFalse(isElementSelected(checkboxChecked));
			elementSelectedStatus(checkboxChecked);
			Assert.assertFalse(isElementSelected(checkboxIndeterminate));
			elementSelectedStatus(checkboxIndeterminate);
		}
		
		@Test
		 
		public void TC_05_Alert() throws InterruptedException {



			
			driver.get("https://automationfc.github.io/basic-form/index.html");
			String alertAccept = "//button[contains(text(),'Click for JS Alert')]";
			driver.findElement(By.xpath(alertAccept)).click();
			Thread.sleep(2000);
			alert = driver.switchTo().alert();
			Assert.assertEquals(alert.getText(), "I am a JS Alert");
			alert.accept();
			Assert.assertEquals(driver.findElement(By.xpath(resultMessage)).getText(), "You clicked an alert successfully");

			
			driver.navigate().refresh();
			
			String alertDismiss = "//button[@onclick='jsConfirm()']";
			driver.findElement(By.xpath(alertDismiss)).click();
			Thread.sleep(2000);
			alert = driver.switchTo().alert();
			Assert.assertEquals(alert.getText(), "I am a JS Confirm");
			alert.dismiss();
			Assert.assertEquals(driver.findElement(By.xpath(resultMessage)).getText(), "You clicked: Cancel");
			
			driver.navigate().refresh();
			
			String  prompt = "//button[@onclick='jsPrompt()']";
			driver.findElement(By.xpath(prompt)).click();
			Thread.sleep(2000);
			alert = driver.switchTo().alert();
			alert.sendKeys(fullName);
			Assert.assertEquals(alert.getText(), "I am a JS prompt");
			alert.accept();
			Assert.assertEquals(driver.findElement(By.xpath(resultMessage)).getText(), "You entered: " + fullName);
		}
		
		
		
		
		
		
		public void elementEnableStatus (String locator) {


			WebElement element = driver.findElement(By.xpath(locator));
			if (element.isEnabled()) {
				System.out.println("Element is enable");
			}
			else
			{
				System.out.println("Element is disable");
			}
			
		} 

		public void checkToCheckbox (String locator) {

			WebElement element = driver.findElement(By.xpath(locator));
			if (!element.isSelected()); {
				element.click();
			}
			
		}
		
		public void uncheckToCheckbox (String locator) {

			WebElement element = driver.findElement(By.xpath(locator));
			if (element.isSelected());{
				element.click();
			}
		}
		public void elementSelectedStatus (String locator) {

			WebElement element = driver.findElement(By.xpath(locator));
			if (element.isSelected()) {
			  System.out.println("Element is selected");
			}
			else {
				System.out.println("Element is deselected");
			}
		}
		
		public boolean isElementSelected (String locator) {



			WebElement element = driver.findElement(By.xpath(locator));
			if (element.isSelected()) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public void sendKeyToElement (By locator, String value) {
			WebElement element = driver.findElement(locator);
			element.sendKeys(value);
		}
		
		public void removeAttributeInDOM(String locator, String attributeRemove) {

		    WebElement element = driver.findElement(By.xpath(locator));
			javascript.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
			}
		public void clickToElementByJS(String locator) {
			WebElement element = driver.findElement(By.xpath(locator));
			javascript.executeScript("arguments[0].click();", element);
		}
		
		
		
		@AfterTest
		
		
		public void afterClass() {
			  driver.quit();
		  }
		
		}		
		
		
		
		