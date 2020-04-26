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

import pageObjects.nopCommerce.FooterMyAccountPageObject;
import pageObjects.nopCommerce.FooterNewProductPageObject;
import pageObjects.nopCommerce.FooterSearchPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageUIs.nopCommerce.AbstractPageUI;

public abstract class AbstractPages {
	
	// Function dùng chung dành riêng cho package (layer) pageObject 
	// Bao gồm những function được wrapper lại từ Selenium lib 
	
	// Biến toàn cục - trong phạm vi class 
	private By byXpath;
	private Actions action;
	private WebElement element;
	private WebDriverWait waitExplicit;
	public Select select;
	
	
		
	// Mở ra 1 url truyền tham số từ bên 
	// driver.get("");
	public void openUrl(WebDriver driver, String urlValue){
		driver.get(urlValue);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
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
		return driver.findElement(byXpathLocator(locator));
	}
	
	public WebElement findElementByXpath(WebDriver driver, String locator, String...values) {
		locator = String.format(locator,(Object[]) values);
		return driver.findElement(byXpathLocator(locator));
	}
	
	public void clickToElement(WebDriver driver,String locator) {
		findElementByXpath(driver, locator).click();
	}
	public void clickToElement(WebDriver driver,String locator, String...values) {
		findElementByXpath(driver, locator, values).click();
	}
	
	
	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public void sendKeyToElement(WebDriver driver,String locator, String valueToSendkey, String...values) {
		findElementByXpath(driver, locator, values).clear();
		findElementByXpath(driver, locator, values).sendKeys(valueToSendkey);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 }
	
	public List<WebElement> findElementsByXpath(WebDriver driver,String locator) {
		return driver.findElements(byXpathLocator(locator));
	}
	
	public List<WebElement> findElementsByXpath(WebDriver driver,String locator, String...values) {
		locator = String.format(locator, (Object[]) values);
		return driver.findElements(byXpathLocator(locator));
	}
	
	public By byXpathLocator(String locator) {
		return  By.xpath(locator);
	}
	
	public By byXpathLocator(String locator, String...values) {
		locator = String.format(locator, (Object[])values);
		System.out.println("Locator" + locator);
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
	
	public String getTextElement (WebDriver driver,String locator,String...values) {
		locator = String.format(locator, (Object[])values);
		return findElementByXpath(driver, locator, values).getText();
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
	
	public boolean isElementDisplayed(WebDriver driver, String locator, String...values) {
		locator = String.format(locator, (Object[])values);
		return findElementByXpath(driver, locator, values).isDisplayed();
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
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byXpath));		
	}
	public void waitToElementVisible(WebDriver driver,String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byXpath));	
	}	
	
	public void waitToElementVisible(WebDriver driver,String locator, String...values) {
		byXpath = byXpathLocator(locator, values);
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byXpath));	
			
	} 
	 public void waitToElementClickable(WebDriver driver,String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));		
	}
	
	public void waitToElementClickable(WebDriver driver,String locator, String...values) {
		byXpath = byXpathLocator(locator, values);
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));		
	}
	
	
	public void waitToPresenceOfElement(WebDriver driver,String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byXpath));		
	}
	
	// Open Footer Page
	// 23 functions -> open 23 pages (Action chain)
	
	public FooterMyAccountPageObject openFooterMyAccountPage(WebDriver driver) {
		waitToElementClickable(driver, AbstractPageUI.FOOTER_MY_ACCOUNT_LINK);
		clickToElement(driver, AbstractPageUI.FOOTER_MY_ACCOUNT_LINK);
		return PageGeneratorManager.getFooterMyAccountPage(driver);
	}
	
	public FooterSearchPageObject openFooterSearchPage(WebDriver driver) {
		waitToElementClickable(driver, AbstractPageUI.FOOTER_SEARCH_LINK);
		clickToElement(driver, AbstractPageUI.FOOTER_SEARCH_LINK);
		return PageGeneratorManager.getFooterSearchPage(driver);
		
	
	}
	public HomePageObject openHomePage(WebDriver driver) {
	    waitToElementDisplayed(driver, AbstractPageUI.HOME_PAGE_LINK);
	    clickToElement(driver, AbstractPageUI.HOME_PAGE_LINK);
	    return PageGeneratorManager.getHomePage(driver);
	    
		
	}
	public FooterNewProductPageObject openFooterNewProductPage(WebDriver driver) {
		waitToElementClickable(driver, AbstractPageUI.FOOTER_NEW_PRODUCT_LINK);
		clickToElement(driver, AbstractPageUI.FOOTER_NEW_PRODUCT_LINK);
		return PageGeneratorManager.getFooterNewProductPage(driver);
	}
	
	// Trong trường hợp application ít page (10-15 )
	public AbstractPages openFooterPageByName(WebDriver driver, String pageName) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_FOOTER_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_FOOTER_LINK, pageName);
		// Factor Pattern 
	 switch (pageName) {
	 	case "Search":
	 return PageGeneratorManager.getFooterSearchPage(driver);
	 	case "New products":
	 return PageGeneratorManager.getFooterNewProductPage(driver);

	default:
		 return PageGeneratorManager.getFooterMyAccountPage(driver);
	}
	}
		
	
	// Trong trường hợp application nhiều page (trên 15 pages)
	public void openFooterPagesByName(WebDriver driver, String pageName) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_FOOTER_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_FOOTER_LINK, pageName);
		}
}
	
	
	
	

