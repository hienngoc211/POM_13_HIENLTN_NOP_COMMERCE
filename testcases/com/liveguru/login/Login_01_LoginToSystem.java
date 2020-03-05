package com.liveguru.login;

import org.testng.annotations.Test;

import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Login_01_LoginToSystem {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private MyDashboardPageObject myDashboardPage;
 
 
  @BeforeClass
  public void beforeClass() {
		
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
		driver.get("http://live.demoguru99.com/index.php");	
		
		homePage = new HomePageObject(driver);
		
		}
  @Test
  public void TC_01_LoginWithEmptyEmailAndPassword() {
	  loginPage = homePage.clickToMyAccountPage();
	  loginPage.inputToEmailTextbox("");
	  loginPage.inputToPasswordTextbox("");
	  
	  loginPage.clickToLoginButton();
	  
	  Assert.assertTrue(loginPage.isEmptyEmailErrorMessageDisplayed());
	  Assert.assertTrue(loginPage.isEmptyPasswordErrorMessageDisplayed());
	  	  
  }
  public void TC_02_LoginWithInvalidEmail() {
	  
	  loginPage.inputToEmailTextbox("123@123.123123");
	  loginPage.inputToPasswordTextbox("");
	  
	  loginPage.clickToLoginButton();
	  Assert.assertTrue(loginPage.isInvalidEmailErrorMessageDisplayed());
	  Assert.assertTrue(loginPage.isInvalidPasswordErrorMessageDisplayed());	  

  }
  public void TC_03_LoginEmailNotExist() {
	  loginPage.inputToEmailTextbox("automationfc" + randomNumber() + "@gmail.com");
	  loginPage.inputToPasswordTextbox("");
	  
	  loginPage.clickToLoginButton();
	  Assert.assertTrue(loginPage.isEmailNotExistEmailErrorMessageDisplayed());
  }
  public void TC_04_LoginWithPasswordLessThan6Chars() {
	  loginPage.inputToEmailTextbox("automationfc" + randomNumber() + "@gmail.com");
	  loginPage.inputToPasswordTextbox("123");
	  
	  loginPage.clickToLoginButton();
	  Assert.assertTrue(loginPage.isInvalidPasswordErrorMessageDisplayed());
  }
  public void TC_05_LoginWithIncorrectPassword() {
	  loginPage.inputToEmailTextbox("automationfc.vn@gmail.com");
	  loginPage.inputToPasswordTextbox("123456789");
	  
	  loginPage.clickToLoginButton();
	  Assert.assertTrue(loginPage.isIncorrectPasswordErrorMessageDisplayed());
  }
  
 
  public void TC_06_LoginWithValidEmailAndPassword() {
	  loginPage.inputToEmailTextbox("automationfc.vn@gmail.com");
	  loginPage.inputToPasswordTextbox("123123");
	  
	  myDashboardPage = loginPage.clickToLoginButton();
	  Assert.assertTrue(myDashboardPage.isFullnameDisplayed());
	  Assert.assertTrue(myDashboardPage.isEmailDisplayed());


  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  public int randomNumber() {
	  Random rand = new Random();
	  return rand.nextInt(999999);

}
}
