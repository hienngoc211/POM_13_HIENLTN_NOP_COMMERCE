package com.testing.browser;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractTest;

public class CloseBrowser extends AbstractTest {
	
	private WebDriver driver;

	@BeforeClass
	
	public void beforeClass() {
		System.out.println("beforeClass");
		driver = getBrowserDriver("firefox");
//		Assert.assertTrue(false);

	}

	@Test
	
	public void TC_01() {
		System.out.println("Test 01");
		
	}
	
	
	@AfterClass(alwaysRun = true)
	
	public void afterClass() {
		System.out.println("AfterClass");
		closeBrowserAndDriver(driver);

	}
}
