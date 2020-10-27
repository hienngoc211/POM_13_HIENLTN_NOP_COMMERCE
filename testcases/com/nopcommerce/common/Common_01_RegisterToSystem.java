package com.nopcommerce.common;


import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import browserFactory.DriverManager;
import browserFactory.DriverManagerFactory;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.FooterMyAccountPageObject;
import pageObjects.nopCommerce.FooterNewProductPageObject;
import pageObjects.nopCommerce.FooterSearchPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;



public class Common_01_RegisterToSystem extends AbstractTest{		

	private WebDriver driver;
	public static String email, password;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private DriverManager driverManager;
	private FooterMyAccountPageObject myAccountPage;
	private FooterNewProductPageObject newProductPage;
	private FooterSearchPageObject searchPage;
	
	
	@Parameters({"browser"})
	@BeforeSuite
	  public void beforeTest(@Optional("firefox") String browserName ) {
	
		 driver = getBrowserDriver(browserName);
//		driver = driverManager.getDriverBrowser();
//		driverManager = DriverManagerFactory.getBrowserManager(browserName);
		
		// Nhược: không theo nguyên tắc đóng gói OOP
		// homePage = new HomePageObject(driver);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		email =  "corona" + randomNumber() + "@gmail.com";
		password = "123123";
		
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
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		driver.quit();

	}
	
}
