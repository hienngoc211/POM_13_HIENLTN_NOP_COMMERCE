package demoexercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class Select_exercise {
		WebDriver driver; 
		Select select;
		Select select1;
		WebDriverWait waitExplicit;
		JavascriptExecutor javascript;
		By gender = By.xpath("//input[@id='gender-female']");
		By firstNametextbox = By.xpath("//input[@id='FirstName']");
		By lastNametextbox = By.xpath("//input[@id='LastName']");
		By emailTextbox = By.xpath("//input[@id='Email']");
		By companyTextbox = By.xpath("//input[@id='Company']");
		By passwordTextbox = By.xpath("//input[@id='Password']");
		By confirmPasswordTextbox = By.xpath("//input[@id='ConfirmPassword']");
		String firstName = "Ngoc Hien";
		String lastName = "Le";
		String email = "hienngoc" + randomNumber() + "@gmail.com";
		String company = "abcdeg";
		String password = "123123";
		String comfirmPassword = "123123";
		By numberAllItems = By.xpath("//ul[@id='number-menu']/li/div");
		By status = By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text' and text()='10']");
		By playItem = By.xpath("//select[@id='games_hidden']/option");

	@BeforeTest
	public void beforeClass() {
	
		System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
		driver = new FirefoxDriver();
		waitExplicit = new WebDriverWait(driver, 10);
		javascript = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	
}
	
	//@Test
	
	public void TC_01() throws InterruptedException {
		driver.get("https://egov.danang.gov.vn/reg"); 
		select = new Select (driver.findElement(By.name("tinhThuongTru")));
		boolean cityDropdownStatus = select.isMultiple();
		Thread.sleep(1000);
		System.out.println("City status multiple is " + cityDropdownStatus);
		Assert.assertFalse(cityDropdownStatus);
		
		select.selectByIndex(4);
		String nameCity = select.getFirstSelectedOption().getText();
		Thread.sleep(1000);
		Assert.assertEquals(nameCity, "thành phố Hồ Chí Minh");
		System.out.println("Tên thành phố/tỉnh: " + nameCity);
		
		select.selectByValue("9715");
		String cityByValue = select.getFirstSelectedOption().getText();
		Thread.sleep(1000);
		Assert.assertEquals(cityByValue, "tỉnh Bà Rịa - Vũng Tàu");
		System.out.println("Tên thành phố/tỉnh: " + cityByValue);
		
		select.selectByVisibleText("tỉnh Lạng Sơn");
		String namecity = select.getFirstSelectedOption().getText();
		Thread.sleep(1000);
		Assert.assertEquals(namecity, "tỉnh Lạng Sơn");
		System.out.println("Tên thàn phố/tỉnh: " + namecity);
		
		int cityTotal = select.getOptions().size();
		System.out.println("Tổng thành phố và tỉnh : " + cityTotal);
		Assert.assertEquals(cityTotal, 65);
		
		List <WebElement> allOptions = select.getOptions();
		for (WebElement option : allOptions) {
			System.out.println("Danh sách các tỉnh thành phố: " + option.getText());
		}
	}
	//@Test
	public void TC_02() throws InterruptedException {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		select = new Select (driver.findElement(By.xpath("//select[@id='job1']")));
		Thread.sleep(3000);
		boolean jobRole1 = select.isMultiple();
		Assert.assertFalse(jobRole1);
		System.out.println("JobRole1 co ho tro thuoc tinh multiple la False hay True? " + jobRole1);
		
		select.selectByVisibleText("Mobile Testing");
		Thread.sleep(3000);
		String project1 = select.getFirstSelectedOption().getText();
		Assert.assertEquals(project1, "Mobile Testing");
		System.out.println("Môn học được chọn bằng visible text là: " + project1);
		
		select.selectByValue("manual");
		Thread.sleep(2000);
		String project2 = select.getFirstSelectedOption().getText();
		Assert.assertEquals(project2, "Manual Testing");
		System.out.println("Môn học được chọn bằng value là: " + project2);
		
		select.selectByIndex(9);
		String project3 = select.getFirstSelectedOption().getText();
		Thread.sleep(2000);
		Assert.assertEquals(project3, "Functional UI Testing");
		System.out.println("Môn học được chọn bằng index là: " + project3);
		
		int totalproject = select.getOptions().size();
		System.out.println("Tổng số môn học là: " + totalproject);
		Assert.assertEquals(totalproject, 10);
		
		select1 = new Select(driver.findElement(By.xpath("//select[@id='job2']")));
		boolean jobRole2 = select1.isMultiple();
		Assert.assertTrue(jobRole2);
		System.out.println("Job role 2 có hỗ trợ thuộc tính multiple là true or false? " + jobRole2);
		
		select1.selectByVisibleText("Automation");
		Thread.sleep(2000);
		String automation = select1.getFirstSelectedOption().getText();
		System.out.println("Môn học multiple được chọn trong jobRole2 là: " + automation);
		
		Thread.sleep(2000);
		select1.selectByVisibleText("Mobile");
		Thread.sleep(2000);
		String mobile = select1.getFirstSelectedOption().getText();
		System.out.println("Môn học multiple được chọn trong jobRole2 là: " + mobile);
		
		Thread.sleep(2000);
		select1.selectByVisibleText("Desktop");
		Thread.sleep(2000);
		String desktop = select1.getFirstSelectedOption().getText();
		System.out.println("Môn học multiple được chọn trong jobRole2 là: " + desktop);
		
		List<WebElement> optionSelected = select1.getAllSelectedOptions();
		Assert.assertEquals(optionSelected.size(), 3);
		List <String> arraySelected = new ArrayList<String>();
		for (WebElement select1 : optionSelected) {
			arraySelected.add(select1.getText());
		}
		Assert.assertTrue(arraySelected.contains("Automation"));
		Assert.assertTrue(arraySelected.contains("Mobile"));
		Assert.assertTrue(arraySelected.contains("Desktop"));
		
		select1.deselectAll();
		List <WebElement> optionUnselected = select1.getAllSelectedOptions();
		Assert.assertEquals(optionUnselected.size(), 0);
		
	}
	
	//@Test
	public void TC_03() throws InterruptedException {
		driver.get("https://demo.nopcommerce.com");
		
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		clickToElement(gender);
		sendKeyToElement(firstNametextbox, firstName);
		sendKeyToElement(lastNametextbox, lastName);
		
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		select.selectByVisibleText("1");
		Thread.sleep(2000);
		int totalday = select.getOptions().size();
		Assert.assertEquals(totalday, 32);
		System.out.println("Có " + totalday + " ngày " +  " trong Daydropdown ");
		
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		select.selectByVisibleText("May");
		Thread.sleep(2000);
		int totalmonth = select.getOptions().size();
		Assert.assertEquals(totalmonth, 13);
		System.out.println("Có " + totalmonth + " tháng " + " trong Monthdropdown ");
		
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		select.selectByVisibleText("1980");
		Thread.sleep(2000);
		int totalYear = select.getOptions().size();
		Assert.assertEquals(totalYear, 112);
		System.out.println("Có " + totalYear + " năm " + " trong Yeardropdown ");
		sendKeyToElement(emailTextbox, email);
		sendKeyToElement(companyTextbox, company);
		sendKeyToElement(passwordTextbox, password);
		sendKeyToElement(confirmPasswordTextbox, comfirmPassword);
		
		driver.findElement(By.xpath("//input[@id='register-button']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ico-account']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ico-logout']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Your registration completed']")).isDisplayed());
			
	}
	
	//@Test
	public void TC_04_jQuery() throws InterruptedException {

		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		selectItemInDropdown("//span[@id='number-button']", "numberAllItems", "10");
		Assert.assertTrue(isElementIsDisplay(status));
		//driver.findElement(By.xpath("//span[@id='number-button']")).click();
		//List <WebElement> allItems = driver.findElements(numberAllItems);
		//waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(numberAllItems));
		//for (WebElement item : allItems) {
		//	if (item.getText().equals("16")) {
				//System.out.println(item.getText());
				//if (item.getText().equals("10")) {
			//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
			//	Actions action = new Actions(driver);
			//	action.moveToElement(item);
			//	action.click();
			//	action.build().perform();
				//item.click();
				//break;
				//}
			//	break;

		//}
		//boolean status = driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text' and text()='10']")).isDisplayed();
		//System.out.println("Status = " + status);
		//Assert.assertTrue(status);
		//Thread.sleep(5000);
		
		}
	@Test
	public void TC_05_Angular() {
		driver.get("https://ej2.syncfusion.com/angular/demos/?_ga=2.262049992.437420821.1575083417-524628264.1575083417#/material/drop-down-list/data-binding");
		selectItemInDropdown("//ejs-dropdownlist[@id='games']", "//select[@id='games_hidden']/option", "Basketball");
		String expectedValue = getTextByJS("#game_hidden > option");
		Assert.assertEquals(expectedValue, "Basketball");
		
	}
	
	@Test
	public void TC_06_React() {
		
	}
			
	
	
	
	
	@AfterTest
	  public void afterClass() {
		  driver.quit();
	  }
	
	 
	
	public void selectItemInDropdown(String parentXpath, String allItemsXpath, String expetedText) {
		driver.findElement(By.xpath(parentXpath)).click();
		List <WebElement> allItems = driver.findElements(By.xpath(allItemsXpath));
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemsXpath)));
		for (WebElement item : allItems) {
		//	if (item.getText().equals("16")) {
				System.out.println(item.getText());
				if (item.getText().equals(expetedText)) {
					item.click();
					break;
			}
				}
	}
	
	public String getTextByJS(String locator) {
		return (String )javascript.executeScript("return document.querySelector('"+ locator +"').text");
	}
	
	public String getTextElement(By by) {
		WebElement element = driver.findElement(by);
		return element.getText();
		
	}
	
	public boolean isElementIsDisplay(By by) {
		WebElement element = driver.findElement(by);
		if (element.isDisplayed()) {
		return true; 
		}
		else {
			return false;
		}
		}

	
	public void clickToElement(By by) {
		WebElement element = driver.findElement(by);
		element.click();
	}
	
	public void sendKeyToElement(By by, String value) {
		WebElement element = driver.findElement(by);
		element.sendKeys(value);
	}
	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(1000);
	}
}
	


