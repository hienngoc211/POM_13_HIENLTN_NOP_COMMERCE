package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends AbstractPages{
	private WebDriver driver;
	private WebDriverWait waitExplicit;
	
	public LoginPageObject(WebDriver localDriver) {
		driver = localDriver;

	}
	
	public LoginPageObject(WebDriver localDriver, WebDriverWait waitExplicit) {
		driver = localDriver;
		this.waitExplicit = waitExplicit;

	}
	public void inputToEmailTextbox(String email) {
		waitToElementDisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementDisplayed(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver) ;
	}
	
	

}
