package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;

public class LoginPageObject extends AbstractPages {
	private WebDriver  driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public void inputToPasswordTextbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public boolean isEmptyEmailErrorMessageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmptyPasswordErrorMessageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isInvalidEmailErrorMessageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isInvalidPasswordErrorMessageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmailNotExistEmailErrorMessageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isInPasswordErrorMessageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isIncorrectPasswordErrorMessageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public MyDashboardPageObject clickToLoginButton() {
		return null;
	}
	

}
