package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashboardPageObject extends AbstractPages{
	private WebDriver driver;
	
	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public boolean isFullnameOrEmailTextDisplayed(String errorMessage) {
		waitToElementDisplayed(driver, String.format(MyDashboardPageUI.LOGIN_SUCCESSFULL_MESSAGE, errorMessage));	
		return isElementDisplayed(driver, String.format(MyDashboardPageUI.LOGIN_SUCCESSFULL_MESSAGE, errorMessage));
	}

}
