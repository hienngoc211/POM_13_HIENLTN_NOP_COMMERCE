package browserFactory;

public class DriverManagerFactory {
	public static DriverManager getBrowserManager(String browserName) {
		DriverManager driverManager;
		switch (browserName) {
		case "chrome":
			driverManager = new ChromeDriverManage();
			break;
		case "firefox":
			driverManager = new FirefoxDriverManage();
			break;
		default:
			driverManager = new ChromeHeadlessDriverManager();
			break;
		}
		return driverManager;
	}

}
