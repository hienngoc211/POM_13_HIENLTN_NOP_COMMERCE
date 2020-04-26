package com.nopcommerce.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
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



public class Login_06_RegisterAndLogin_Multi_Browser_Brallel extends AbstractTest{		

	private WebDriver driver;
	private String email, password, registerSuccessMsg;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	
	@Parameters({"browser"})
	@BeforeTest
	  public void beforeTest(String browserName ) {
	
		driver = getBrowserDriver (browserName);
		System.out.println("Driver at testclass = " + driver.toString());
		
		// Nhược: không theo nguyên tắc đóng gói OOP
		// homePage = new HomePageObject(driver);
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
		registerPage.clickToFemailRadio();	
		registerPage.inputToFirstName("Micheal");
		registerPage.inputToLastName("Obama");
		registerPage.selectDay("1");
		registerPage.selectMonth("March");
		registerPage.selectYear("1985");
		registerPage.inputToEmailTextbox(email);	
		registerPage.inputToCompanyTextbox("abcd");
		registerPage.inputToPasswordTextbox(password);
		registerPage.sendkeyToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		
		registerSuccessMsg = registerPage.getRegisterSuccessMessage();
		Assert.assertEquals(registerSuccessMsg, "Your registration completed");
		
		// Logout to System -> Home Page 
		homePage = registerPage.clickToLogoutLink();
	}
	
	@Test
	public void TC_02_LoginToSystem() {
		

		loginPage = homePage.clickToLoginLink();
	
		loginPage.inputToEmailTextbox(email);
		
		loginPage.inputToPasswordTextbox(password);
		
		homePage = loginPage.clickToLoginButton();
	
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