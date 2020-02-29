package com.nopcommerce.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.AbstractPages;
import pageObjects.ComputerPageObject;
import pageObjects.DesktopPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Login_03_RegisterAndLogin_AbstractPage_Object extends AbstractPages {		

	private WebDriver driver;
	private String email, password, registerSuccessMsg;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private ComputerPageObject computerPage;
	private DesktopPageObject desktopPage;
	
	
	@BeforeTest
	  public void beforeTest() {
		
		
		//String osName = System.getProperty("os.name");		
		//if (osName.toLowerCase().contains("window")) {
			//System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver.exe");
		//}
			//else if (osName.toLowerCase().contains("mac")) {
				System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
			//}
				//else {
					//System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver_linux");
				//}
	
		driver = new FirefoxDriver();
		
		System.out.println("Driver at testcase = " + driver.toString());;
		
			
		openUrl(driver, "https://demo.nopcommerce.com/");
		
		// --> Home Page 
		homePage = new HomePageObject(driver);
		
		email =  "corona" + randomNumber() + "@gmail.com";
		password = "123123";
		
		
		}

	@Test
	public void TC_01_RegisterToSystem() {
		
		// Home page: Click to Register link -> Register Page
		
		registerPage = homePage.clickToRegisterLink();
		
		// Click to Femail radio button 
		registerPage.clickToFemailRadio();
		
		
		// Sendkey to First name textbox
		registerPage.inputToFirstName("Micheal");
		
		
		// Sendkey to Last name textbox
		registerPage.inputToLastName("Obama");
		
		
		// Select item in Day
		registerPage.selectDay("1");
		
		
		// Select item in Month
		registerPage.selectMonth("March");

		// Select item in Year
		registerPage.selectYear("1985");

		// Sendkey to Email textbox
		registerPage.inputToEmailTextbox(email);
		
		// Sendkey to Company name textbox
		registerPage.inputToCompanyTextbox("abcd");

		
		// Sendkey to Password textbox
		registerPage.inputToPasswordTextbox(password);

		
		
		// Sendkey to Confirm password textbox 
		registerPage.sendkeyToConfirmPasswordTextbox(password);

		// Click to Register button
		registerPage.clickToRegisterButton();

		// Verify registered success
		registerSuccessMsg = registerPage.getRegisterSuccessMessage();
		Assert.assertEquals(registerSuccessMsg, "Your registration completed");
		
		// Logout to System -> Home Page 
		homePage = registerPage.clickToLogoutLink();
	}
	
	@Test
	public void TC_02_LoginToSystem() {
		
		// Click to Login -> Login Page
		loginPage = homePage.clickToLoginLink();
	
		
		// Input to Email textbox
		loginPage.inputToEmailTextbox(email);
		
		// Input to Password textbox
		loginPage.inputToPasswordTextbox(password);
	
		
		// Click to Login button --> Home Page
		homePage = loginPage.clickToLoginButton();
		// Verify My account link displayed
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
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
