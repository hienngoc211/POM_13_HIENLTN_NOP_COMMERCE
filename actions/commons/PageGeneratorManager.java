package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.FooterMyAccountPageObject;
import pageObjects.nopCommerce.FooterNewProductPageObject;
import pageObjects.nopCommerce.FooterSearchPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class PageGeneratorManager {

	// Cấp phát việc khởi tạo đối tượng cho Home Page
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
}
	// Cấp phát việc khởi tạo đối tượng cho Register Page
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	// Cấp phát việc khởi tạo đối tượng cho Login Page
	public static LoginPageObject getLoginPage(WebDriver driver) {
	return new LoginPageObject(driver);
}

	// Cấp phát việc khởi tạo đối tượng cho Footer My Account Page 
	public static FooterMyAccountPageObject getFooterMyAccountPage(WebDriver driver) {
	return new FooterMyAccountPageObject(driver);
}
	// Cấp phát việc khởi tạo đối tượng cho Footer New Product Page 
	public static FooterNewProductPageObject getFooterNewProductPage (WebDriver driver) {
		return new FooterNewProductPageObject(driver);
	}
	
	// Cấp phát việc khởi tạo đối tượng cho Footer Search Page 
	public static FooterSearchPageObject getFooterSearchPage (WebDriver driver) {
		return new FooterSearchPageObject(driver);
	}
}
