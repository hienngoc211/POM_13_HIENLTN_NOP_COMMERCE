package commons;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	
	//Biến toàn cục (trong phạm vi class)
	public WebDriver driver;
	private long longTimeOut = 30;
	private Actions action;
	private WebElement element;
	private By byXpath;
	private WebDriverWait waitExplicit;
	// Mở ra Url truyền tham số từ bên ngoài
	// driver.get(https://facebook.com")
	public void openURL(String urlValue) {
		
		driver.get(urlValue);
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public void back() {
		driver.navigate().back();;
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
	
	public  String getTextAlert() {
		return driver.switchTo().alert().getText();

	}
	public void sendKeyToAlert(String value) {
		
	}
	public WebElement findElementByXpath(String locator) {
		return driver.findElement(byXpathLocator(locator));
	}
	
	public List<WebElement> findElementsByXpath(String locator) {
		return driver.findElements(byXpathLocator(locator));
	}
	
	public By byXpathLocator(String locator) {
		return By.xpath(locator);
	}
	public void clickToElement(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}
	public void sendKeyToElement(String locator, String value) {
		driver.findElement(By.xpath(locator)).sendKeys(value);
	}
		
	public int countElementNumber(String locator) {
		return findElementsByXpath(locator).size();
	}
	
	public String getAttributeElement(String locator, String attributeName) {
		return findElementByXpath(locator).getAttribute(attributeName);
	}
	public boolean isElementDisplayed(String locator) {
		return findElementByXpath(locator).isDisplayed();
	}
	
	public void hoverMouseToElement(String locator) {
		action = new Actions(driver);
		element = findElementByXpath(locator);
		action.moveToElement(element).perform();
	}
	public void doubleClickToElement (String locator) {
		action = new Actions(driver);
		element = findElementByXpath(locator);
	}
	
	public void waitToElementDisplayed(String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver,longTimeOut);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
	}
	public void waitToElementClickable(String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver,longTimeOut);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));
	}
}
