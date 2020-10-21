package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopCommerce.HomePageObject;



public class Login_11_RegisterAndLogin_Assert_Verify_Log_Report extends AbstractTest{		

	private WebDriver driver;
	private HomePageObject homePage;
	
	
	
	@Parameters({"browser"})
	@BeforeTest
	  public void beforeTest(@Optional("firefox") String browserName ) {
	
		//driver = getBrowserDriver (browserName);
		//homePage = PageGeneratorManager.getHomePage(driver);	
	}

	@Test 
	public void TC_01_Assert() {
		log.info("TC_01 - Step 01: Open new customer page");
		// newCustomerPage = homePage.opennewCustomerPage(driver);
		
		 log.info("TC_01 - Step 02: Verify New Customer Page display");
		 assertTrue(true);
		 
		 log.info("TC_01 - Step 03: Verify New Customer form not display");
		 assertTrue(false);
		 
		 log.info("TC_04 - Step 04: Verify Home Page not display");
		 assertTrue(true);
	}
	@Test 
	public void TC_02_Verify() {
		log.info("TC_01 - Step 01: Open new customer page");
		// newCustomerPage = homePage.opennewCustomerPage(driver);
		
		 log.info("TC_01 - Step 02: Verify New Customer Page display");
		 verifyTrue(true);
		 
		 log.info("TC_01 - Step 03: Verify New Customer form not display");
		 verifyTrue(false);
		 
		 log.info("TC_04 - Step 04: Verify Home Page not display");
		 verifyTrue(true);
	}
	
	@AfterTest
	public void afterTest() {
		//driver.quit();
		  }


}

	// Cơ chế thư viện assert của testNG là khi một step bị fail nó sẽ dừng/đánh fail test case luôn và chuyển qua testcase tiếp 
	// Cơ chế thư viện verify của testNG là nếu như một step bị fail nó sẽ chạy tiếp các step còn lại, ko phải chạy bộ scrip nhiều lần
