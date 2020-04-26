package com.nopcommerce.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;



public class Login_05_RegisterAndLogin_PageGenerator extends AbstractTest {		

	private WebDriver driver;
	private String email, password, registerSuccessMsg;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	
	@Parameters({"browser"})
	@BeforeTest
	  public void beforeTest(String browserName) {
		
		getBrowserDriver(browserName);

	
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		email =  "corona" + randomNumber() + "@gmail.com";
		password = "123123";
		
		
		}

	@Test
	public void TC_01_RegisterToSystem() {
		
		// ----------------- 1 - HomePage -> Register Page ------------------------
		
		// C2: Đưa việc khởi tạo vào trong hàm 
		// Ưu: Thấy được sự kết nối 
		// Che dấu được sự khởi tạo 
		registerPage = homePage.clickToRegisterLink();
		
		// C1: Thấy viêc khởi tạo trên chính tầng testcase
		// không có sự kết nối giữa 2 page 
		// không tuân theo nguyên tắc đóng gói của lập trình HĐT
		registerPage = new RegisterPageObject(driver);
		
		
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
