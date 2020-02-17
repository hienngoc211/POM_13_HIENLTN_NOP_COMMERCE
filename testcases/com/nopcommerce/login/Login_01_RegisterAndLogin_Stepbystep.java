package com.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login_01_RegisterAndLogin_Stepbystep {
	
	private WebDriver driver;
	private Select select;
	private String email, password;
	
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
		
		driver = new FirefoxDriver();
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com/");
	  
	  
	  //Generate random email
	  email = "corona" + randomNumber() + "@gmail.com";
	  password = "coronavirus";
	  
   }

  @Test
  public void TC_01_RegisterToSystem() {
	  //Click to Register link
	  driver.findElement(By.cssSelector(".ico-register")).click();
	  //Click male radio button
	  driver.findElement(By.cssSelector("#gender-female")).click();
	  driver.findElement(By.cssSelector("#FirstName")).sendKeys("Corona");
	  driver.findElement(By.cssSelector("#LastName")).sendKeys("Virus");
	  
	  select = 	new Select (driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
	  select.selectByVisibleText("4");

	  select = 	new Select (driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
	  select.selectByVisibleText("February");

	  select = 	new Select (driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
	  select.selectByVisibleText("1987");

	  
	  
	  driver.findElement(By.cssSelector("#Email")).sendKeys(email);;
	  driver.findElement(By.cssSelector("#Company")).sendKeys("Corona Virus");;

	  driver.findElement(By.cssSelector("#Password")).sendKeys(password);;
	  driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(password);;
	  driver.findElement(By.cssSelector("#register-button")).click();
			
	  //Verify registered success
	  String resultText = driver.findElement(By.cssSelector(".result")).getText();
	  Assert.assertEquals(resultText, "Your registration completed");
	  
	  //Logout to System  
	  driver.findElement(By.cssSelector(".ico-logout")).click();


  }
  
  @Test
  public void TC_02_LoginToSystem() throws Exception {
	  
	  //Click Login link
	  driver.findElement(By.cssSelector(".ico-login")).click();
	  driver.findElement(By.cssSelector("#Email")).sendKeys(email);
	  driver.findElement(By.cssSelector("#Password")).sendKeys(password);
	  driver.findElement(By.cssSelector(".login-button")).click();
	  
	  //Verify My Account link displayed 
	  Assert.assertTrue(driver.findElement(By.cssSelector(".ico-account")).isDisplayed());
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