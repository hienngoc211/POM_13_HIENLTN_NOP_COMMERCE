package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;

public class MyDashboardPageObject extends AbstractPages{
	private WebDriver driver;
	
	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFullnameDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmailDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
