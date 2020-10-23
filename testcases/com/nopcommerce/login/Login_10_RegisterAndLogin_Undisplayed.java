package com.nopcommerce.login;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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



public class Login_10_RegisterAndLogin_Undisplayed extends AbstractTest{		

	private WebDriver driver;
	private WebElement element;
	private String email, password, registerSuccessMsg;
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
	
		driver = getBrowserDriver(browserName);
		//driverManager = DriverManagerFactory.getBrowserManager(browserName);
		//driver = driverManager.getDriverBrowser();
		
		// Nhược: không theo nguyên tắc đóng gói OOP
		// homePage = new HomePageObject(driver);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		email =  "corona" + randomNumber() + "@gmail.com";
		password = "123123";
		
		
	}

	@Test 
	public void TC_01_CheckDisplayed() {
		registerPage = homePage.clickToRegisterLink();
		// Firstname textbox displayed
		Assert.assertTrue(registerPage.isFirstnameTextboxDisplayed());
		
	
	}
	@Test
	public void TC_02_CheckUndisplayed_In_DOM() {
			// Request verifycation Token undisplayed (have in DOM)
		Assert.assertTrue(registerPage.isRequestVerifyTokenTextboxUndisplayed());
		Assert.assertFalse(registerPage.isRequestVerifyTokenTextboxDisplayed());
		
	}	
	@Test
	public void TC_03_CheckUndisplayed_Not_in_DOM() {
			// Register button undisplayed (ko có trong DOM)
		Assert.assertTrue(registerPage.isRegisterButtonUndisplayed());
		
	}		

	

	public boolean isElementUndisplayed(String locator) {
		Date date = new Date();
		System.out.println("Start time = " + date.toString());
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		
		if (elements.size() == 0) {
			System.out.println("Element not in DOM");
			System.out.println("End time = " + new Date().toString());
			return true;
		} else if (elements.size()>0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible/displayed");
			System.out.println("End time = " + new Date().toString());
			return true;
		} else {
			System.out.println("Element in DOM and visible");
			return false;
		}
	}	
		
		
	
	public void startTime() {
		System.out.println("Start time = " + new Date());
	}
	public void endTime () {
		System.out.println("End time = " + new Date());
	}
	
  

	@AfterTest
	public void afterTest() {
		driver.quit();
		  }

}
