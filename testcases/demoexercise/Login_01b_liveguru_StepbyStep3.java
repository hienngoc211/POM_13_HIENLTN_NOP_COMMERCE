package demoexercise;


import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Login_01b_liveguru_StepbyStep3 {
	 WebDriver driver;
	By username = By.xpath("//input[@name='uid']");
	By password = By.xpath("//input[@name='password']");
	By buttonLogin = By.xpath("//input[@name='btnLogin']");
	By newCustomerbtn = By.xpath("//a[contains(text(),'New Customer')]");
	By customerName = By.xpath("//input[@name='name']");
	By gender = By.xpath("//input[@value='m']");
	By dateOfBirth = By.xpath("//input[@id='dob']");
	By address = By.xpath("//textarea[@name='addr']");
	By city = By.xpath("//input[@name='city']");
	By state = By.xpath("//input[@name='state']") ;
	By pin = By.xpath("//input[@name='pinno']") ;
	By mobileNumber = By.xpath("//input[@name='telephoneno']");
	By email = By.xpath("//input[@name='emailid']");
	By pwCustomer = By.xpath("//input[@name='password']");
	By submitBtn = By.xpath("//input[@name='sub']");
	By editBtn = By.xpath("//a[contains(text(),'Edit Customer')]");
	
	
  @BeforeTest
  
  public void beforeTest() {
	  
      System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
      driver = new FirefoxDriver ();

      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      driver.get("http://demo.guru99.com/v4/");
  }

  @Test
  public void Test() throws InterruptedException {
	 sendkeyToElement(username, "mngr279444");
	 sendkeyToElement(password, "jequnuq");
	 clickToElement(buttonLogin);
	 String homepageWelcomemsg = driver.findElement(By.xpath("//table[@align='center']//marquee[@class='heading3']")).getText();
	 Assert.assertEquals(homepageWelcomemsg, "Welcome To Manager's Page of Guru99 Bank");
	 Thread.sleep(2000);
	 System.out.println(homepageWelcomemsg);
	 clickToElement(newCustomerbtn);
	 Thread.sleep(2000);
	 
	 //String customerID = driver.findElement(By.xpath("//td[contains(text(),'Customer ID')]//following-sibling::td")).getText();
	 //Assert.assertEquals(customerID, "5961");
	// System.out.println("ID khach hang = " + customerID );
	 sendkeyToElement(customerName, "Jackson");
	 Thread.sleep(1000);
	 sendkeyToElement(gender, "Male");
	 Thread.sleep(1000);
	 sendkeyToElement(dateOfBirth, "06/28/1987");
	 Thread.sleep(1000);
	 sendkeyToElement(address, "26 Hai Phong");
	 Thread.sleep(1000);
	 sendkeyToElement(city, "Da Nang");
	 Thread.sleep(1000);
	 sendkeyToElement(state, "Hai Chau");
	 Thread.sleep(1000);
	 sendkeyToElement(pin, "234890");
	 Thread.sleep(1000);
	 sendkeyToElement(mobileNumber, "09786544789");
	 Thread.sleep(1000);
	 sendkeyToElement(email, "Micheal" + randomNumber() + "@gmail.com");
	 Thread.sleep(1000);
	 sendkeyToElement(pwCustomer, "1234abcde!");
	 Thread.sleep(1000);
	 clickToElement(submitBtn);
	 Thread.sleep(1000);
	 Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Customer Registered Successfully!!!']")).isDisplayed()); 
	 System.out.println("Customer Registered Successfully!!!");
	
	 
	 
	 
	  
	  
  }

  @AfterTest
  public void afterClass() {
	  driver.quit();
  }
  
  public boolean isElementDisplayed(By by)	{
		WebElement element = driver.findElement(by);
		if(element.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

  	public void clearElement(By by) {
  		WebElement element = driver.findElement(by);
  		element.clear();
  	}
	
  public void sendkeyToElement(By by, String value) {
		WebElement element = driver.findElement(by);
		element.sendKeys(value);
	}
  public boolean isElementSeclected(By by) {
		WebElement element = driver.findElement(by);
		if(element.isSelected()) {
			System.out.println("Checkbox is selected");
			return true;
		} else {
			return false;
		}
  }
  public void clickToElement(By by ) {
	  WebElement element = driver.findElement(by);
	  element.click();
  }
  public boolean isElementEnabled(By by) {
		WebElement element = driver.findElement(by);
		if(element.isEnabled()) {
			return true;
		} else {
		return false;
		}
	}
  public int randomNumber() {
	  Random rand = new Random();
	  return rand.nextInt(1000); 
  }
 
	 
 }



