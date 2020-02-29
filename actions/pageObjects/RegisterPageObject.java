package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPages{
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver localDriver) {
		driver = localDriver;

	}

	public void clickToFemailRadio() {
		waitToElementClickable(driver, RegisterPageUI.GENDER_FEMAIL_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_FEMAIL_RADIO);
	}

	public void inputToFirstName(String firstNameValue) {
		waitToElementDisplayed(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstNameValue);
		
	}

	public void inputToLastName(String lastNameValue) {
		waitToElementDisplayed(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastNameValue);
	}

	public void selectDay(String expectedItem) {
		waitToElementClickable(driver, RegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.DAY_DROPDOWN, expectedItem);;
	}

	public void selectMonth(String expectedItem) {
		waitToElementClickable(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, expectedItem);
	}

	public void selectYear(String expectedItem) {
		waitToElementClickable(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, expectedItem);
	}

	public void inputToEmailTextbox(String email) {
		waitToElementDisplayed(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToCompanyTextbox(String company) {
		waitToElementDisplayed(driver, RegisterPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, company);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementDisplayed(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void sendkeyToConfirmPasswordTextbox(String confirmPassword) {
		waitToElementDisplayed(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getRegisterSuccessMessage() {
		waitToElementDisplayed(driver, RegisterPageUI.REGISTER_SUCCESS_TEXT);
		return getTextElement(driver, RegisterPageUI.REGISTER_SUCCESS_TEXT);

	}

	public HomePageObject clickToLogoutLink() {
		waitToElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return new HomePageObject(driver);
	}

	
		
	}

	


