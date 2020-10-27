package com.framework.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBankGuruSite {

		WebDriver driver;
		
	@Test
	
	public void TC_01() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/");
		
//		driver.quit();
	}
}
