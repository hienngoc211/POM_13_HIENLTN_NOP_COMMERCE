package com.framework.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPages;

public class Handle_DataTable_Grid extends AbstractPages{
	WebDriver  driver;
	String locator;
	String total;
	int index;
	
	@BeforeClass
	 	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	  }
 
	//@Test
		public void TC_01_Click_To_Page() {
		driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
		
		// 5
		goToPageByPageNumber("5");
		sleepInSecond(2);
		Assert.assertTrue(isPageActivedByPageNumber("5"));
		
		// 10
		goToPageByPageNumber("10");
		sleepInSecond(2);
		Assert.assertTrue(isPageActivedByPageNumber("10"));
		
		// 16
		goToPageByPageNumber("16");
		sleepInSecond(2);
		Assert.assertTrue(isPageActivedByPageNumber("16"));
		
		
  }
	
	//@Test
	public void TC_02_Click_To_Icon_By_Country() {
	driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
	
		// remove/delete
		clickToIconNameByCountryName("Afghanistan", "remove");
		sleepInSecond(1);
		clickToIconNameByCountryName("Armenia", "remove");
		sleepInSecond(1);
		clickToIconNameByCountryName("Angola", "remove");
		sleepInSecond(1);
		
		// edit
		
		clickToIconNameByCountryName("Aruba", "edit");
		sleepInSecond(1);
	
	}
	
	//@Test
	public void TC_03_Get_Total_Value_Icon_By_Country() {
	driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
	
		total = getTotalValueByCountryName("Argentina");
		System.out.println("Total of Argentina = " + total);
		Assert.assertEquals(total, "687522");
		
		total = getTotalValueByCountryName("Albania");
		System.out.println("Total of Albania = " + total);
	}
	
	@Test
	public void TC_04_Input_To_Textbox() {
	driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
	
		//InputToTextboxByColumnAndRowNumber("company", "2", "ABC");
		InputToTextboxByColumnAndRow("Company", "2", "ABC");
		sleepInSecond(2);
		
		//InputToTextboxByColumnAndRowNumber("name", "1", "Apolo");
		InputToTextboxByColumnAndRow("Contact Person", "1", "Apolo");
		sleepInSecond(2);
		
		//InputToTextboxByColumnAndRowNumber("orderPlaced", "3", "500")
		InputToTextboxByColumnAndRow("Order Placed", "3", "500");
		sleepInSecond(2);
	}
	
	@Test
	public void TC_05_Click_Icon_By_Row() {
		driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		// Remove row 1
		clickToIconByRowNumber("Remove Current Row", "1");
		sleepInSecond(2);
		
		// Insert row 1
		clickToIconByRowNumber("Insert Row Above", "1");
		sleepInSecond(2);
		
		// Move up row 3
		clickToIconByRowNumber("Move Up", "3");
		sleepInSecond(2);
	}
	
	
	// Go to page by page number
	public void goToPageByPageNumber(String pageNumber) {
		locator = "//a[@class = 'qgrd-pagination-page-link' and text()='%s']";
		waitToElementClickable(driver, locator, pageNumber);
		clickToElement(driver, locator, pageNumber);
		
	}
	
	public boolean isPageActivedByPageNumber(String pageNumber) {
		locator = "//a[@class = 'qgrd-pagination-page-link active' and text()='%s']";
		waitToElementVisible(driver,locator, pageNumber);
		return isElementDisplayed(driver, locator, pageNumber);
		
		
	}
	
	public void clickToIconNameByCountryName(String countryName, String iconName) {

		locator = "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-%s-row-btn']";
		waitToElementClickable(driver, locator, countryName, iconName);
		clickToElement(driver, locator, countryName, iconName);
		
	}
	
	public String getTotalValueByCountryName(String countryName) {
		locator = "//td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='total']";
		waitToElementVisible(driver, locator, countryName);
		return getTextElement(driver, locator, countryName);
	}
	
	public void InputToTextboxByColumnAndRowNumber(String columnName, String rowNumber, String value) {
		locator = "//input[@id='tblAppendGrid_%s_%s']";
		waitToElementVisible(driver,locator, columnName, rowNumber);
		sendKeyToElement(driver, locator, value, columnName, rowNumber );
	}
	
	public void InputToTextboxByColumnAndRow (String columnName, String rowNumber, String value) {
		locator = "//th[contains(text(),'%s')]/preceding-sibling::th";
		index = findElementsByXpath(driver, locator, columnName).size() + 1;
		locator = "//tr["+ rowNumber + "]/td[" + index + "]/input";
		waitToElementVisible(driver, locator);
		sendKeyToElement(driver, locator, value);
		
	}
	
	public void clickToIconByRowNumber(String iconName , String rowNumber) {
		locator = "//tbody//tr[%s]//button[@title='%s']";
		waitToElementClickable(driver, locator, rowNumber, iconName);
		clickToElement(driver, locator, rowNumber, iconName);
	}

	@AfterClass
		public void afterClass() {
		driver.quit();
		
  }

}
