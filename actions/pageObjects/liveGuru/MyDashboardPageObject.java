package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.liveGuru.LoginPageUI;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashboardPageObject extends AbstractPages{
	private WebDriver driver;
	
	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public boolean isFullnameOrEmailTextDisplayed(String errorMessage) {
		waitToElementDisplayed(driver, String.format(MyDashboardPageUI.EMAIL_PASSWORD_TEXT, errorMessage));	
		return isElementDisplayed(driver, String.format(MyDashboardPageUI.EMAIL_PASSWORD_TEXT, errorMessage));
	}

}
