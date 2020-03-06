package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends AbstractPages {
	private WebDriver  driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	
	}

	public void inputToEmailTextbox(String email) {
		waitToElementDisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
		 
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementDisplayed(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public MyDashboardPageObject clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return new MyDashboardPageObject(driver);
	}

	public boolean isEmptyEmailErrorMessageDisplayed(String errorMessage) {
		waitToElementDisplayed(driver, String.format(LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE, errorMessage));	
		return isElementDisplayed(driver, String.format(LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE, errorMessage));
	}

	public boolean isEmptyPasswordErrorMessageDisplayed(String errorMessage) {
		waitToElementDisplayed(driver, String.format(LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE, errorMessage));	
		return isElementDisplayed(driver, String.format(LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE, errorMessage));		
	}

	public boolean isInvalidEmailErrorMessageDisplayed(String errorMessage) {
		waitToElementDisplayed(driver, String.format(LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE, errorMessage));	
		return isElementDisplayed(driver, String.format(LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE, errorMessage));	
	}

	public boolean isEmailNotExistOrInvalidPasswordErrorMessageDisplayed(String errorMessage) {
		waitToElementDisplayed(driver, String.format(LoginPageUI.EMAIL_NOT_EXIST_ERROR_MESSAGE, errorMessage));	
		return isElementDisplayed(driver, String.format(LoginPageUI.EMAIL_NOT_EXIST_ERROR_MESSAGE, errorMessage));	
	}

	public boolean isPasswordLessThan6CharsErrorMessage(String errorMessage) {
		waitToElementDisplayed(driver, String.format(LoginPageUI.PASSWORD_LESS_THAN_ERROR_MESSAGE, errorMessage));	
		return isElementDisplayed(driver, String.format(LoginPageUI.PASSWORD_LESS_THAN_ERROR_MESSAGE, errorMessage));
	}

	

	
}
	
