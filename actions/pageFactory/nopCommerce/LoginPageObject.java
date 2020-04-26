package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends AbstractPagesFactory{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver localDriver) {
		driver = localDriver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(xpath = "//input[@class='button-1 login-button']")
	private WebElement loginButton;
	
	public void inputToEmailTextbox(String email) {
		waitToElementDisplayed(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementDisplayed(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, password);
	}

	public HomePageObject clickToLoginButton() {
		waitToElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
		return new HomePageObject(driver) ;
	}
	
	

}
