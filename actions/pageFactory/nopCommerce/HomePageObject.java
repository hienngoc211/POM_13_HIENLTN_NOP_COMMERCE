package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends AbstractPages {
		WebDriver driver;
		
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		
	}
	public RegisterPageObject clickToRegisterLink() {
		waitToElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return new RegisterPageObject(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitToElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return new LoginPageObject(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
   
	}

	
	
}
