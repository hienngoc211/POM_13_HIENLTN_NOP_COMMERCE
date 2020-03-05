package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends AbstractPages{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver localDriver) {
		driver = localDriver;

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
		return new HomePageObject(driver) ;
	}
	
	

}
