package com.nopcommerce.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
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



public class Login_09_RegisterAndLogin_Dynamic_Locator extends AbstractTest{		

	private WebDriver driver;
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
	
		// driver = getBrowserDriver (browserName);
		driverManager = DriverManagerFactory.getBrowserManager(browserName);
		driver = driverManager.getDriverBrowser();
		
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
	@Test(description = "Only use incase less page")
	public void TC_03_Dynamic_Less() {
		// Home Page -> My Account (Footer)
			myAccountPage = (FooterMyAccountPageObject) homePage.openFooterPageByName(driver,"My account"); // ép kiểu 
			myAccountPage.sleepInSecond(2);
		// My Account -> Search 
			searchPage = (FooterSearchPageObject) myAccountPage.openFooterPageByName(driver,"Search");;
			searchPage.sleepInSecond(2);
		// Search -> New products
			newProductPage = (FooterNewProductPageObject) searchPage.openFooterPageByName(driver, "New products");
			newProductPage.sleepInSecond(2);
		// New products -> HomePage
			newProductPage.openHomePage(driver);
			newProductPage.sleepInSecond(2);
		// HomePage -> Search
			searchPage = (FooterSearchPageObject) homePage.openFooterPageByName(driver,"Search");
			searchPage.sleepInSecond(2);
			
		// Search -> My account
			myAccountPage = (FooterMyAccountPageObject) searchPage.openFooterPageByName(driver,"My account");
			
		// My Account -> New products
			newProductPage = (FooterNewProductPageObject) myAccountPage.openFooterPageByName(driver,"New products");
			
		 // New products -> Search
			searchPage = (FooterSearchPageObject) newProductPage.openFooterPageByName(driver,"Search");
	}
	
	// Xử lý việc khởi tạo đối tượng trong chính step trong testcase

	@Test(description = "Only use incase more page")
	public void TC_04_Dynamic_Than() {
		// New Products -> My Account (Footer)
					newProductPage.openFooterPagesByName(driver,"My account");
					myAccountPage = PageGeneratorManager.getFooterMyAccountPage(driver);
					myAccountPage.sleepInSecond(2);
				// My Account -> Search 
					myAccountPage.openFooterPagesByName(driver,"Search");
					searchPage = PageGeneratorManager.getFooterSearchPage(driver);
					searchPage.sleepInSecond(2);
				// Search -> New products
					searchPage.openFooterPagesByName(driver, "New products");
					newProductPage = PageGeneratorManager.getFooterNewProductPage(driver);
					newProductPage.sleepInSecond(2);
				// New products -> HomePage
					homePage = newProductPage.openHomePage(driver);
					newProductPage.sleepInSecond(2);
				// HomePage -> Search
					homePage.openFooterPagesByName(driver,"Search");
					searchPage = PageGeneratorManager.getFooterSearchPage(driver);
					searchPage.sleepInSecond(2);
					
				// Search -> My account
					searchPage.openFooterPagesByName(driver,"My account");
					myAccountPage = PageGeneratorManager.getFooterMyAccountPage(driver);
					myAccountPage.sleepInSecond(2);
					
				// My Account -> New products
					myAccountPage.openFooterPagesByName(driver,"New products");
					newProductPage = PageGeneratorManager.getFooterNewProductPage(driver);
				 // New products -> Search
					newProductPage.openFooterPagesByName(driver,"Search");
					searchPage = PageGeneratorManager.getFooterSearchPage(driver);
			}
			
	
  

	@AfterTest
	public void afterTest() {
		driver.quit();
		  }

}
