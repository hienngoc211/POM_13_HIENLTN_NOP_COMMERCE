package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.liveGuru.HomePageUI;

public class HomePageObject extends AbstractPages {
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public LoginPageObject clickToMyAccountPage() {
		waitToElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return new LoginPageObject(driver);
	}

}