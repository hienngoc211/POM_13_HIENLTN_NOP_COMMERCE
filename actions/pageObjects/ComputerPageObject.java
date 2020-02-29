package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.HomePageUI;

public class ComputerPageObject extends AbstractPages {
	WebDriver driver;

	public ComputerPageObject(WebDriver _driver) {
		driver = _driver;

	}

	public DesktopPageObject clickDesktopMenu() {
		waitToElementClickable(driver, HomePageUI.COMPUTER_MENU);
		hoverMouseToElement(driver, HomePageUI.COMPUTER_MENU);
		waitToPresenceOfElement(driver,HomePageUI.DESKTOP_MENU);
		clickToElement(driver, HomePageUI.DESKTOP_MENU);
		return new DesktopPageObject(driver);
	}

}
