package POM_demo;

public class GetOSName {

	public static void main(String[] args) {
		String osName = System.getProperty("os.Name");
		System.out.println(osName.toLowerCase());
		
		if (osName.toLowerCase().contains("windows")) {
			System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver.exe");
			
		} else if(osName.toLowerCase().contains("mac")){
			System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
		} else {
			System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodrive_linux");

		}
	}

}
