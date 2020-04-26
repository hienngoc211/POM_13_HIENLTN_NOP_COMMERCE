package commons;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	
	// Function dùng chung dành riêng cho package (layer) pageObject 
	// Bao gồm những function được wrapper lại từ Selenium lib 
	
	// Biến toàn cục - trong phạm vi class 
	private WebDriver driver;
	private By byXpath;
	private Actions action;
	private WebElement element;
	private WebDriverWait waitExplicit;
	private Select select;
	
	public AbstractPage(WebDriver localDriver){
		System.out.println("Driver at testcase = " + localDriver);
		driver = localDriver;
		System.out.println("Driver at abstract = " + driver);
	}
		
	// Mở ra 1 url truyền tham số từ bên 
	// driver.get("");
	public void openUrl(String urlValue){
		driver.get(urlValue);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public void back() {
		driver.navigate().back();
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert() {
		driver.switchTo().alert().dismiss();
	}
	
	public String getTextAlert() {
		return driver.switchTo().alert().getText();
	}
	
	public void sendKeyToAlert(String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	
	
	public WebElement findElementByXpath(String locator) {
		return driver.findElement(byXpathLocator(locator));
	}
	
	public void clickToElement(String locator) {
		findElementByXpath(locator).click();
	}
	
	public void sendKeyToElement(String locator, String value) {
		findElementByXpath(locator).sendKeys(value);
	 }
	
	public List<WebElement> findElementsByXpath(String locator) {
		return driver.findElements(byXpathLocator(locator));
	}
	
	public By byXpathLocator(String locator) {
		return  By.xpath(locator);
	}
	
	public void selectItemInDropdown(String locator, String value) {
		element = findElementByXpath(locator);
		select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public String getTextElement (String locator) {
		return findElementByXpath(locator).getText();
	}
	
	
	public int countElementNumber(String locator) {
		return findElementsByXpath(locator).size();
	}
	
	public String getAttribuiteElement(String locator, String AttribuiteName) {
		return findElementByXpath(locator).getAttribute(AttribuiteName);
	}
	
	public boolean isElementDisplayed(String locator) {
		return findElementByXpath(locator).isDisplayed();
	}
	
	public void hoverMouseToElement(String locator) {
		// Biến cục bộ - Phạm vi method/hàm
		action = new Actions(driver);
		element = findElementByXpath(locator);
		action.moveToElement(element).perform();
	}
	
	public void doubleClickToElement(String locator) {
		action = new Actions(driver);
		element = findElementByXpath(locator);
	}
	
	public void waitToElementDisplayed(String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byXpath));		
	}
	
	public void waitToElementClickable(String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));		
	}
}
