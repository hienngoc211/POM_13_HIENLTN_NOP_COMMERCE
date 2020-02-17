package com.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class Login_02_RegisterAndLogin_AbstractPage_Declare {
	
	private WebDriver driver;
	private String email, password;
	
	// Declare an instance of Abstract Page
	private AbstractPage abstractPage;
	
  @BeforeTest
  
   public void beforeTest() {
	  
	  String osName = System.getProperty("os.name");
	  
	  if (osName.toLowerCase().contains("windows")) {
			System.setProperty("webdriver.gecko.driver", ".//BrowserDrivers/geckodriver.exe");
			
		} else if(osName.toLowerCase().contains("mac")){
			System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
		} else {
			System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodrive_linux");

		}
	  
	  System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
	  driver = new FirefoxDriver(); 

	  
	  //Init Abstract Page 
	  
	  abstractPage = new AbstractPage(driver);	  
	  
	  abstractPage.openURL("https://demo.nopcommerce.com/");
	  
	  
	  
	  
	  //Generate random email
	  email = "corona" + randomNumber() + "@gmail.com";
	  password = "coronavirus";
	  
   }

  @Test
  public void TC_01_RegisterToSystem() {
	  //Click to Register link
	  abstractPage.clickToElement("//a[@class='ico-register']");
	  //driver.findElement(By.cssSelector(".ico-register")).click();
	  
	  //Click male radio button
	  abstractPage.clickToElement("//input[@id='gender-male']");
	  //driver.findElement(By.cssSelector("#gender-female")).click();
	  
	   abstractPage.sendKeyToElement("//input[@id='FirstName']", "Corona");
	  //driver.findElement(By.cssSelector("#FirstName")).sendKeys("Corona");
	  
	   abstractPage.sendKeyToElement("//input[@id='LastName']", "Virus");
	  //driver.findEendelement(By.cssSelector("#LastName")).sendKeys();
	  
	  
	   abstractPage.selectItemtoDropdown("//select[@name='DateOfBirthDay']", "4");
	   //select = new Select (driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
	  //select.selectByVisibleText("4");
	   
	   abstractPage.selectItemtoDropdown("//select[@name='DateOfBirthMonth']", "February");
	  //select = new Select (driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
	  //select.selectByVisibleText("February");

	   abstractPage.selectItemtoDropdown("//select[@name='DateOfBirthYear']", "1987");
	  //select = new Select (driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
	  //select.selectByVisibleText("1987");

	  
	   abstractPage.sendKeyToElement("//input[@id='Email']", email);
	  //driver.findElement(By.cssSelector("#Email")).sendKeys(email);
	   
	   abstractPage.sendKeyToElement("//input[@id='Company']", "Corona Virus");
	  //driver.findElement(By.cssSelector("#Company")).sendKeys("Corona Virus");;
	   
	   abstractPage.sendKeyToElement("//input[@id='Password']", password);
	  //driver.findElement(By.cssSelector("#Password")).sendKeys(password);
	   
	   abstractPage.sendKeyToElement("//input[@id='ConfirmPassword']", password); 
	  //driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(password);
	 
	   
	   abstractPage.clickToElement("//input[@id='register-button']"); 
	  //driver.findElement(By.cssSelector("#register-button")).click();
	   
			
	  //Verify registered success
	  String resultText = abstractPage.getTextElement("//div[@class='result']");
	  Assert.assertEquals(resultText, "Your registration completed");
	  
	  //Logout to System  
	  
	   abstractPage.clickToElement("//a[@class='ico-logout']"); 
	  //driver.findElement(By.cssSelector(".ico-logout")).click();


  }
  
  @Test
  public void TC_02_LoginToSystem() throws Exception {
	  
	  //Click Login link
	  
	   abstractPage.clickToElement("//a[@class='ico-login']"); 
	   abstractPage.sendKeyToElement("//input[@id='Email']", email ); 
	   abstractPage.sendKeyToElement("//input[@id='Password']", email ); 
	   abstractPage.clickToElement("//input[@class='button-1 login-button'] "); 

	  //driver.findElement(By.cssSelector(".ico-login")).click();
	  //driver.findElement(By.cssSelector("#Email")).sendKeys(email);
	  //driver.findElement(By.cssSelector("#Password")).sendKeys(password);
	  //driver.findElement(By.cssSelector(".login-button")).click();
	  
	  //Verify My Account link displayed 
	  Assert.assertTrue(abstractPage.isElementDisplayed("//a[@class='ico-account']"));
  }
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  
  public int randomNumber() {
	  Random rand = new Random();
	  return rand.nextInt(999999);
  }
}
