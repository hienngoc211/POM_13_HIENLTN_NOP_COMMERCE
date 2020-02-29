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

public class AbstractPages {
	
	// Function dùng chung dành riêng cho package (layer) pageObject 
	// Bao gồm những function được wrapper lại từ Selenium lib 
	
	// Biến toàn cục - trong phạm vi class 
	private long longTimeOut = 30;
	private By byXpath;
	private Actions action;
	private WebElement element;
	private WebDriverWait waitExplicit;
	public Select select;
	
	
		
	// Mở ra 1 url truyền tham số từ bên 
	// driver.get("");
	public void openUrl(WebDriver driver, String urlValue){
		driver.get(urlValue);
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public void back(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void sendKeyToAlert(WebDriver driver,String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	
	
	public WebElement findElementByXpath(WebDriver driver,String locator) {
		return driver.findElement(byXpathLocator(driver, locator));
	}
	
	public void clickToElement(WebDriver driver,String locator) {
		findElementByXpath(driver, locator).click();
	}
	
	public void sendKeyToElement(WebDriver driver,String locator, String value) {
		findElementByXpath(driver, locator).clear();
		findElementByXpath(driver, locator).sendKeys(value);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 }
	
	public List<WebElement> findElementsByXpath(WebDriver driver,String locator) {
		return driver.findElements(byXpathLocator(driver, locator));
	}
	
	public By byXpathLocator(WebDriver driver,String locator) {
		return  By.xpath(locator);
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String value) {
		element = findElementByXpath(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public String getTextElement (WebDriver driver,String locator) {
		return findElementByXpath(driver, locator).getText();
	}
	
	
	public int countElementNumber(WebDriver driver,String locator) {
		return findElementsByXpath(driver, locator).size();
	}
	
	public String getAttribuiteElement(WebDriver driver,String locator, String AttribuiteName) {
		return findElementByXpath(driver, locator).getAttribute(AttribuiteName);
	}
	
	public boolean isElementDisplayed(WebDriver driver,String locator) {
		return findElementByXpath(driver, locator).isDisplayed();
	}
	
	public void hoverMouseToElement(WebDriver driver,String locator) {
		// Biến cục bộ - Phạm vi method/hàm
		action = new Actions(driver);
		element = findElementByXpath(driver, locator);
		action.moveToElement(element).perform();
	}
	
	public void doubleClickToElement(WebDriver driver,String locator) {
		action = new Actions(driver);
		element = findElementByXpath(driver, locator);
	}
	
	public void waitToElementDisplayed(WebDriver driver,String locator) {
		byXpath = byXpathLocator(driver, locator);
		waitExplicit = new WebDriverWait(driver, longTimeOut);
		waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byXpath));		
	}
	
	public void waitToElementClickable(WebDriver driver,String locator) {
		byXpath = byXpathLocator(driver, locator);
		waitExplicit = new WebDriverWait(driver, longTimeOut);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));		
	}
	
	public void waitToPresenceOfElement(WebDriver driver,String locator) {
		byXpath = byXpathLocator(driver, locator);
		waitExplicit = new WebDriverWait(driver, longTimeOut);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byXpath));		
	}
}
