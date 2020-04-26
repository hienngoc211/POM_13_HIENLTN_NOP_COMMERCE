package pageUIs.nopCommerce;

public class AbstractPageUI {
	public static final String HOME_PAGE_LINK= "//div[@class='header-logo']//img";

	// Footer = 23 links (pages)= 23 locators
	public static final String FOOTER_SEARCH_LINK = "//div[@class='footer']//a[contains(text(),'Search')]";
	public static final String FOOTER_NEW_PRODUCT_LINK = "//div[@class='footer']//a[contains(text(),'New products')]";
	public static final String FOOTER_MY_ACCOUNT_LINK = "//div[@class='footer']//a[contains(text(),'My account')]";



	// 1 locator
	
	public static final String DYNAMIC_FOOTER_LINK = "//div[@class='footer']//a[contains(text(),'%s')]";
	
	}
