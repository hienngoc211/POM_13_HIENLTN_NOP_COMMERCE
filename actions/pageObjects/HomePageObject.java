package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPages {
		WebDriver driver;
		
	public HomePageObject(WebDriver _driver) {
		driver = _driver;
		
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
	public ComputerPageObject clickComputerMenu() {
		waitToElementClickable(driver, HomePageUI.COMPUTER_MENU);
		clickToElement(driver, HomePageUI.COMPUTER_MENU);
		return new ComputerPageObject(driver);
	}
	public DesktopPageObject clickDesktopMenu() {
		waitToElementClickable(driver, HomePageUI.COMPUTER_MENU);
		hoverMouseToElement(driver, HomePageUI.COMPUTER_MENU);
		clickToElement(driver, HomePageUI.DESKTOP_MENU);
		return new DesktopPageObject(driver);
	}
	
	
	
}
