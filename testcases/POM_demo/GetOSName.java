package POM_demo;

public class GetOSName {

	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		System.out.println(osName.toLowerCase());
		
		if (osName.toLowerCase().contains("window")) {
			System.setProperty("webdriver.gecko.driver", ".//BrowserDrivers/geckodriver.exe");
		}
			else if (osName.toLowerCase().contains("mac")) {
				System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver");
			}
				else {
					System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver_linux");				}
				}
				
				}
		
		

