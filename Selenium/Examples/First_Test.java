package Examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class First_Test {

	public static void main(String[] args) throws InterruptedException{

		// Create an instance of WebDriver
		WebDriver driver = new FirefoxDriver();

		try {
			// Open the test page
			driver.get("https://training-support.net/");

			// Performing actions on the page
			// Assertions
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// Close the browser
			Thread.sleep(1000);
			driver.quit(); // Close all windows/tabs

			// driver.close(); // Close the active window/tab
		}
	}

}