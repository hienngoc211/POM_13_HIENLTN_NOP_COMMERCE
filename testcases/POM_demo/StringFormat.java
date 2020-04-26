package POM_demo;

public class StringFormat {

	public static void main(String[] args) {
		String DYNAMIC_FOOTER_LINK = "//div[@class='footer']//a[contains(text(),'%s')]";
		String DYNAMIC_HEADER_FOOTER_LINK = "//div[@class='%s']//a[contains(text(),'%s')]";
		
		String DYNAMIC_COUNTRY_TEXT = "//td[text()='Afghanistan']/following-sibling::td[@data-key='total']";
		
		// 4 params
		String DYNAMIC_COUNTRY_MALE_FEMALE_TOTAL = "//td[@data-key ='females' and text()='%s']/following-sibling::td"
				+ "[@data-key='country' and text()='%s']/following-sibling::td["
				+ "@data-key='males' and text()='%s']//following-sibling::td"
				+ "[@data-key='total' and text()='%s']";
		
		clickToFooterLink(DYNAMIC_FOOTER_LINK, "Search");
		clickToFooterLink(DYNAMIC_FOOTER_LINK, "My Account");
		clickToFooterLink(DYNAMIC_FOOTER_LINK, "Shopping cart");
		
		// 2 param
		clickToFooterLink(DYNAMIC_HEADER_FOOTER_LINK, "header", "Computers");
		clickToFooterLink(DYNAMIC_HEADER_FOOTER_LINK, "header", "Electronics");
		clickToFooterLink(DYNAMIC_HEADER_FOOTER_LINK, "footer", "Search");
		clickToFooterLink(DYNAMIC_HEADER_FOOTER_LINK, "footer", "Shopping cart");
		
		// 1 param
		clickToFooterLink(DYNAMIC_COUNTRY_TEXT, "Afghanistan");
		clickToFooterLink(DYNAMIC_COUNTRY_TEXT, "Algeria");
		
		// 4 params
		clickToFooterLink(DYNAMIC_COUNTRY_MALE_FEMALE_TOTAL, "338282", "Argentina", "349238", "687522");
		clickToFooterLink(DYNAMIC_COUNTRY_MALE_FEMALE_TOTAL, "276880", "Angola", "276472", "553353");
		clickToFooterLink(DYNAMIC_COUNTRY_MALE_FEMALE_TOTAL, "67000", "Paraguay", "69600", "137000");
	
		
	}
	
	//public static void clickToFooterLink(String locator, String pageName) {
	//	locator = String.format(locator, pageName);
	//	System.out.println("Click to page with 1 parameter = " + locator);
		
	//}
	//public static void clickToFooterLink(String locator, String headerOrFooterName, String pageName) {
	//	locator = String.format(locator, headerOrFooterName, pageName);
	//	System.out.println("Click to page with 2 params = " + locator);

//}
	//public static void clickToFooterLink(String locator, String female, String countryName, String Male, String total) {
	//	locator = String.format(locator, female, countryName, Male, total);
	//	System.out.println("Click to page with 4 params = " + locator);
//}
	// Cùng số lượng tham số nhưng khác nhau về kiểu dữ liệu String
	public static void clickToFooterLink(String locator, String...values) {
		locator = String.format(locator, (Object[]) values);
		System.out.println("Click to page with n params = " + locator);
	}
	
	// Kiểu dữ liệu int 
	//public static void clickToFooterLink(String locator, int...values) {
	//	locator = String.format(locator, (int[]) values);
	//	System.out.println("Click to page with n params = " + locator);
	//}
}

