package com.nopcommerce.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.AbstractPages;

public class Login_03_RegisterAndLogin_AbstractPage_Extends extends AbstractPages {

	private WebDriver driver;
	private String email, password;
	
	
	@BeforeTest
	  public void beforeTest() {
		
		
		String osName = System.getProperty("os.name");		
		if (osName.toLowerCase().contains("window")) {
			System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver.exe");
		}
			else if (osName.toLowerCase().contains("mac")) {
				System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
			}
				else {
					System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver_linux");
				}
	
		driver = new FirefoxDriver();
		System.out.println("Driver at testcase = " + driver.toString());;
		
			
		openUrl(driver, "https://demo.nopcommerce.com/");
		
		email =  "corona" + randomNumber() + "@gmail.com";
		password = "123123";
		
		
		}	
	
	

	@Test
	public void TC_01_RegisterToSystem() {
		
		// Click to Register link
		//driver.findElement(By.cssSelector(".ico-register")).click();
		clickToElement(driver, "//a[@class='ico-register']");
		
		// Click to Femail radio button 
		//driver.findElement(By.cssSelector("#gender-female")).click();
		clickToElement(driver, "//input[@id='gender-female']");

		
		// Sendkey to First name textbox
		//driver.findElement(By.cssSelector("#FirstName")).sendKeys("Corona");
		sendKeyToElement(driver, "//input[@id='FirstName']","Corona");
		
		// Sendkey to Last name textbox
		//driver.findElement(By.cssSelector("#LastName")).sendKeys("Virus");
		sendKeyToElement(driver, "//input[@id='LastName']", "Virus");
		
		// Select item in Day
		//select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
		//select.selectByVisibleText("1");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']","1");
		
		
		// Select item in Month
		//select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
		//select.selectByVisibleText("March");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']","March");

		// Select item in Year
		//select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
		//select.selectByVisibleText("1987");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']","1989");

		// Sendkey to Email textbox
		//driver.findElement(By.cssSelector("#Email")).sendKeys(email);br 
		sendKeyToElement(driver, "//input[@id='Email']", email);
		
		// Sendkey to Company name textbox
		//driver.findElement(By.cssSelector("#Company")).sendKeys("Corona Virus");
		sendKeyToElement(driver, "//input[@id='Company']", "Corona Virus");
		
		// Sendkey to Password textbox
		//driver.findElement(By.cssSelector("#Password")).sendKeys(password);
		sendKeyToElement(driver, "//input[@id='Password']", password);

		
		// Sendkey to Confirm password textbox 
		//driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(password);
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", password);

		
		// Click to Register button
		//driver.findElement(By.cssSelector("#register-button")).click();
		clickToElement(driver, "//input[@id='register-button']");
		
		// Verify registered success
		//String resultText = driver.findElement(By.cssSelector(".result")).getText();
		//Assert.assertEquals(resultText, "Your registration completed");
		String resultText = getTextElement(driver, "//div[@class='result']");
		Assert.assertEquals(resultText, "Your registration completed");

		
		// Logout to System
		//driver.findElement(By.cssSelector(".ico-logout")).click();
		clickToElement(driver, "//a[@class='ico-logout']");

	}
	
	@Test
	public void TC_02_LoginToSystem() {
		
		// Click to Login
		//driver.findElement(By.cssSelector(".ico-login")).click();
		clickToElement(driver, "//a[@class='ico-login']");
		
		// Input to Email textbox
		//driver.findElement(By.cssSelector("#Email")).sendKeys(email);
		sendKeyToElement(driver, "//input[@id='Email']", email);
		
		// Input to Password textbox
		//driver.findElement(By.cssSelector("#Password")).sendKeys(password);
		sendKeyToElement(driver, "//input[@id='Password']", password);
		
		// Click to Login button
		//driver.findElement(By.cssSelector(".login-button")).click();
		clickToElement(driver, "//input[@class='button-1 login-button']");
		
		// Verify My account link displayed
		//Assert.assertTrue(driver.findElement(By.cssSelector(".ico-account")).isDisplayed());
		//abstractPage.isElementDisplayed("//a[@class='ico-account']");
		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));
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
