package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		// Create an instance of WebDriver
		WebDriver driver = new FirefoxDriver();

		try {
			// Open the test page
			driver.get("https://training-support.net/");

			// Performing actions on the page
			// Printing the title of the first page
			System.out.println("The Title of the page is: " + driver.getTitle());

			// Finding the Element using the locator and click
			driver.findElement(By.partialLinkText("About")).click();

			// Printing the title of the second page
			System.out.println("The Title of the New Page is: " + driver.getTitle());

			// Assertions
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// Close the browser
			driver.quit(); // Close all windows/tabs
		}

	}

}
