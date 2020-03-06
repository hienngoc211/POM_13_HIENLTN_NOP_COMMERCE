package pageUIs.liveGuru;

public class LoginPageUI {
	
	public static final String EMAIL_TEXTBOX = "//input[@id='email']";
	
	public static final String PASSWORD_TEXTBOX = "//input[@id='pass']";
	
	public static final String LOGIN_BUTTON = "//button[@id='send2']";
	
	// This is a required field.
	public static final String EMPTY_EMAIL_ERROR_MESSAGE = "//div[@id='advice-required-entry-email']";
	// This is a required field.
	public static final String EMPTY_PASSWORD_ERROR_MESSAGE = "//div[@id='advice-required-entry-pass']";
	// Please enter a valid email address. For example johndoe@domain.com.
	public static final String INVALID_EMAIL_ERROR_MESSAGE = "//div[@id='advice-validate-email-email']";
	// Invalid login or password.
	public static final String EMAIL_NOT_EXIST_ERROR_MESSAGE = "//span[contains(text(),'Invalid login or password.')]";
	// Please enter 6 or more characters without leading or trailing spaces.
	public static final String PASSWORD_LESS_THAN_ERROR_MESSAGE = "//div[@id='advice-validate-password-pass']";
	// Invalid login or password.
	public static final String INCORRECT_PASSWORD_ERROR_MESSAGE = "//span[contains(text(),'Invalid login or password.')]";
}