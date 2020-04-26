package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HomePageObject extends AbstractPagesFactory {
		WebDriver driver;
		
	public HomePageObject(WebDriver driver) {
		// Gán 
		this.driver = driver;
		
		// Khởi tạo element và lưu vào cache
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;
	
	@FindBy(how = How.XPATH, using = "//a[@class='ico-login']")
	private WebElement loginLink;
	
	@FindBy(how = How.XPATH, using = "//a[@class='ico-account']")
	private WebElement myAccountLink;
	
	public RegisterPageObject clickToRegisterLink() {
		waitToElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
		// Khởi tạo page 
		return new RegisterPageObject(driver);
		
	}
	
	public LoginPageObject clicktoMyLoginLink() {
		waitToElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
		return new LoginPageObject(driver);
	}
	
	public boolean isMyAccountLinkDisplayed() {
		waitToElementDisplayed(driver, myAccountLink);
		return isElementDisplayed(driver,myAccountLink);
		
	}

	

	
	
}

