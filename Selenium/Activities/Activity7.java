package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {
	public static void main(String[] args) {
		// Create an instance of WebDriver
		WebDriver driver = new FirefoxDriver();

		try {
			// Open the test page
			driver.get("https://training-support.net/webelements/dynamic-controls");

			// Printing the title of the first page
			System.out.println("The Title of the page is: " + driver.getTitle());

			// Find the text box element
			WebElement tb = driver.findElement(By.id("textInput"));

			// Check whether the text box is enabled
			System.out.println("Is the text box enabled? " + tb.isEnabled());

			// Click the enable button of the text box
			driver.findElement(By.id("textInputButton")).click();

			// Check whether the text box is enabled
			System.out.println("Is the text box enabled? " + tb.isEnabled());
			
			tb.sendKeys("MaddyWiz");
			
			String text = tb.getDomProperty("value");
			
			System.out.println(text);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// Close the browser
			driver.quit(); // Close all windows/tabs
		}

	}
}
