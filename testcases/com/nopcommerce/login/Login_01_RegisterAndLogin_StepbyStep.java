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

public class Login_01_RegisterAndLogin_StepbyStep {
	
	private WebDriver driver;
	private Select select;
	private String email, password;
	
	@BeforeTest
	  public void beforeTest() {
		
		System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
			
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
		email =  "corona" + randomNumber() + "@gmail.com";
		password = "123123";
		
		
	  }		
	
	@Test
	public void TC_01_RegisterToSystem() {
		
		// Click to Register link
		driver.findElement(By.cssSelector(".ico-register")).click();
		
		// Click to Femail radio button 
		driver.findElement(By.cssSelector("#gender-female")).click();
		
		// Sendkey to First name textbox
		driver.findElement(By.cssSelector("#FirstName")).sendKeys("Corona");
		
		// Sendkey to Last name textbox
		driver.findElement(By.cssSelector("#LastName")).sendKeys("Virus");
		
		// Select item in Day
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
		select.selectByVisibleText("1");
		
		// Select item in Month
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
		select.selectByVisibleText("March");
		
		// Select item in Year
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
		select.selectByVisibleText("1987");
		
		// Sendkey to Email textbox
		driver.findElement(By.cssSelector("#Email")).sendKeys(email);
		
		// Sendkey to Company name textbox
		driver.findElement(By.cssSelector("#Company")).sendKeys("Corona Virus");
		
		// Sendkey to Password textbox
		driver.findElement(By.cssSelector("#Password")).sendKeys(password);
		
		// Sendkey to Confirm password textbox 
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(password);
		
		// Click to Register button
		driver.findElement(By.cssSelector("#register-button")).click();
		
		// Verify registered success
		String resultText = driver.findElement(By.cssSelector(".result")).getText();
		Assert.assertEquals(resultText, "Your registration completed");
		
		// Logout to System
		driver.findElement(By.cssSelector(".ico-logout")).click();

	}
	
	@Test
	public void TC_02_LoginToSystem() {
		
		// Click to Login
		driver.findElement(By.cssSelector(".ico-login")).click();
		
		// Input to Email textbox
		driver.findElement(By.cssSelector("#Email")).sendKeys(email);
		
		// Input to Password textbox
		driver.findElement(By.cssSelector("#Password")).sendKeys(password);
		
		// Click to Login button
		driver.findElement(By.cssSelector(".login-button")).click();
		
		// Verify My account link displayed
		Assert.assertTrue(driver.findElement(By.cssSelector(".ico-account")).isDisplayed());
	}
	
  

	@AfterTest
	public void afterTest() {
		driver.quit();
		  }
	
	private int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

}
