package com.nopcommerce.login;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Login_01b_RegisterAndLogin_StepbyStep2 {
	private WebDriver driver;
	By emailTextbox = By.id("email");
	By usernameTextbox = By.id("new_username");
	By newpassword = By.id("new_password");
	By lowercaseComplete = By.xpath("//li[@class='lowercase-char completed']");
	By SignupButton = By.id("create-account");
	By numbercharComplete = By.xpath("//li[@class='number-char completed']");
	By tickcircle = By.xpath("//span[@class='freddicon tick-circle']");
	By labelText = By.xpath("//h4[contains(text(),'Your password is secure and you're all set!')]");
	By checkbox = By.xpath("//input[@id='marketing_newsletter']");
	By emailcreatetext = By.xpath("//h1[text() = 'Check your email']");
	
  @BeforeTest
  
  public void beforeTest() {
	  
      System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
      driver = new FirefoxDriver ();

      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      driver.get("https://login.mailchimp.com/signup/");
  }

  @Test
  public void Test() throws InterruptedException {
	  
	  // driver.findElement(By.id("")).sendKeys("");
	  sendkeyToElement(emailTextbox, "vitvitvit@gmail.com");
	  //driver.findElement(By.id("new_username")).sendKeys("khaithienlenguyen");
	  sendkeyToElement(usernameTextbox, "viquankhaithien3456");

	  //driver.findElement(By.id("new_password")).sendKeys("a");
	  sendkeyToElement(newpassword, "a");
	  Assert.assertTrue(isElementDisplayed(lowercaseComplete));
	  
	  //Assert.assertEquals(driver.findElement(By.id("create-account")).getAttribute("disabled"), "true");
	  Assert.assertFalse(isElementEnabled(SignupButton));
	  Thread.sleep(3000);

	  //driver.findElement(By.id("new_password")).clear();
	  //driver.findElement(By.id("new_password")).sendKeys("1");
	  //Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
	  //Assert.assertEquals(driver.findElement(By.id("create-account")).getAttribute("disabled"), "true");
	  //Assert.assertFalse(driver.findElement(By.id("create-account")).isEnabled());
	  clearElement(newpassword);
	  sendkeyToElement(newpassword, "1");
	  Assert.assertTrue(isElementDisplayed(numbercharComplete));
	  Assert.assertFalse(isElementEnabled(SignupButton));
	  Thread.sleep(3000);

	  //driver.findElement(By.id("new_password")).clear();
	  //driver.findElement(By.id("new_password")).sendKeys("1aA#1234");
	  //Assert.assertTrue(driver.findElement(By.xpath("//span[@class='freddicon tick-circle']")).isDisplayed());
	  //Assert.assertTrue(driver.findElement(By.xpath("//h4[contains(text(),\"Your password is secure and you're all set!\")]")).isDisplayed());
	  //Assert.assertEquals(driver.findElement(By.id("create-account")).getAttribute("disabled"), null);
	  clearElement(newpassword);
	  sendkeyToElement(newpassword, "1aA#1234");
	  Assert.assertTrue(isElementDisplayed(tickcircle));
	  Assert.assertTrue(isElementDisplayed(labelText));
	  Assert.assertTrue(isElementEnabled(SignupButton));
	   System.out.println("Sign up button is enable");
	  Thread.sleep(3000);
	  
	  //Assert.assertFalse(isElementSeclected(Checkbox));
	  //clickToElement(Checkbox);
	 // Assert.assertTrue(isElementSeclected(Checkbox));
	  //Thread.sleep(3000);
	  Assert.assertFalse(isElementSeclected(checkbox));
	  clickToElement(checkbox);
	  Assert.assertTrue(isElementSeclected(checkbox));
	  Thread.sleep(3000);
	  
	  
	  //driver.findElement(By.id("create-account")).click();
	  //Thread.sleep(3000);
	  //Assert.assertTrue(driver.findElement(By.xpath("//h1[text() = 'Check your email']")).isDisplayed());
	  
	  clickToElement(SignupButton);
	  Thread.sleep(3000);
	  Assert.assertTrue(isElementDisplayed(emailcreatetext));
	 
	  
	  
  }

  @AfterTest
  public void afterClass() {
	  driver.quit();
  }
  
  public boolean isElementDisplayed(By by)	{
		WebElement element = driver.findElement(by);
		if(element.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

  	public void clearElement(By by) {
  		WebElement element = driver.findElement(by);
  		element.clear();
  	}
	
  public void sendkeyToElement(By by, String value) {
		WebElement element = driver.findElement(by);
		element.sendKeys(value);
	}
  public boolean isElementSeclected(By by) {
		WebElement element = driver.findElement(by);
		if(element.isSelected()) {
			System.out.println("Checkbox is selected");
			return true;
		} else {
			return false;
		}
  }
  public void clickToElement(By by ) {
	  WebElement element = driver.findElement(by);
	  element.click();
  }
  public boolean isElementEnabled(By by) {
		WebElement element = driver.findElement(by);
		if(element.isEnabled()) {
			return true;
		} else {
		return false;
		}
	}

}

