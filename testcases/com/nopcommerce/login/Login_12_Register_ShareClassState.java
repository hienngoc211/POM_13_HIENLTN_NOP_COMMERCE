package com.nopcommerce.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_RegisterToSystem;

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



public class Login_12_Register_ShareClassState extends AbstractTest{		

	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private DriverManager driverManager;
	private FooterMyAccountPageObject myAccountPage;
	private FooterNewProductPageObject newProductPage;
	private FooterSearchPageObject searchPage;
	
	
	@Parameters({"browser"})
	@BeforeTest
	  public void beforeTest(String browserName ) {
	
//		driver = getBrowserDriver (browserName);
		driver = driverManager.getDriverBrowser();
		driverManager = DriverManagerFactory.getBrowserManager(browserName);
		
		// Nhược: không theo nguyên tắc đóng gói OOP
		// homePage = new HomePageObject(driver);
		homePage = PageGeneratorManager.getHomePage(driver);
		loginPage = homePage.clickToLoginLink();
	
		loginPage.inputToEmailTextbox(Common_01_RegisterToSystem.email);
		
		loginPage.inputToPasswordTextbox(Common_01_RegisterToSystem.password);
		
		homePage = loginPage.clickToLoginButton();
	
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
				
	}

	@Test
	public void TC_01_ViewProduct() {
		
	}
	@Test
	public void TC_02_() {
		
	}	
	@Test
	public void TC_03_Payment() {
		
	}
	@AfterTest
	public void afterTest() {
		driver.quit();
		  }

}
