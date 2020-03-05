package POM_demo;

public class StringFormat {

	public static void main(String[] args) {
		String EMPTY_EMAIL_MESSAGE = "//div[@id='advice-required-entry-email'] and text()='%s'";
		EMPTY_EMAIL_MESSAGE = String.format(EMPTY_EMAIL_MESSAGE, "This is a required field.");
		System.out.println(EMPTY_EMAIL_MESSAGE);
					
	}

}
