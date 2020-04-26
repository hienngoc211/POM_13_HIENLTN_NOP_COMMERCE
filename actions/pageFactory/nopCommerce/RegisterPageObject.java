package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class RegisterPageObject extends AbstractPagesFactory{
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver localDriver) {
		driver = localDriver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//input[@id='gender-female']")
	private WebElement genderfemailRadio;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstNameTextbox;
	
	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;
	
	@FindBy(name = "DateOfBirthDay")
	private WebElement dateOfBirth;
	
	@FindBy(name = "DateOfBirthMonth")
	private WebElement dateOfMonth;
	
	@FindBy(name = "DateOfBirthYear")
	private WebElement dateOfYear ;
	
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Company")
	private WebElement companyTextbox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessText;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;

	public void clickToFemailRadio() {
		waitToElementClickable(driver, genderfemailRadio);
		clickToElement(driver, genderfemailRadio);
	}

	public void inputToFirstName(String firstNameValue) {
		waitToElementDisplayed(driver, firstNameTextbox);
		sendKeyToElement(driver, firstNameTextbox, firstNameValue);
		
	}

	public void inputToLastName(String lastNameValue) {
		waitToElementDisplayed(driver, lastNameTextbox);
		sendKeyToElement(driver, lastNameTextbox, lastNameValue);
	}

	public void selectDay(String expectedItem) {
		waitToElementClickable(driver, dateOfBirth);
		selectItemInDropdown(driver, dateOfBirth, expectedItem);;
	}

	public void selectMonth(String expectedItem) {
		waitToElementClickable(driver, dateOfMonth);
		selectItemInDropdown(driver, dateOfMonth, expectedItem);
	}

	public void selectYear(String expectedItem) {
		waitToElementClickable(driver, dateOfYear);
		selectItemInDropdown(driver, dateOfYear, expectedItem);
	}

	public void inputToEmailTextbox(String email) {
		waitToElementDisplayed(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, email);
	}

	public void inputToCompanyTextbox(String company) {
		waitToElementDisplayed(driver, companyTextbox);
		sendKeyToElement(driver, companyTextbox, company);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementDisplayed(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, password);
	}

	public void sendkeyToConfirmPasswordTextbox(String confirmPassword) {
		waitToElementDisplayed(driver, confirmPasswordTextbox);
		sendKeyToElement(driver, confirmPasswordTextbox, confirmPassword);
	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getRegisterSuccessMessage() {
		waitToElementDisplayed(driver, registerSuccessText);
		return getTextElement(driver, registerSuccessText);

	}

	public HomePageObject clickToLogoutLink() {
		waitToElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
		return new HomePageObject(driver);
	}

	
		
	}

	


