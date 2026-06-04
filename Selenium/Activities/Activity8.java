package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity8 {
	public static void main(String[] args) {
		// Create an instance of WebDriver
		WebDriver driver = new FirefoxDriver();

		// Initializing explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(11));

		try {
			// Open the test page
			driver.get("https://training-support.net/webelements/dynamic-content");

			// Printing the title of the first page
			System.out.println("The Title of the page is: " + driver.getTitle());

			// Finding the "Click Me" button and clicking it
			driver.findElement(By.id("genButton")).click();

			// Wait until the word "release" appears using the Explicit Wait
			w.until((ExpectedConditions.textToBe(By.id("word"), "release")));

			// Print the word
			String text = driver.findElement(By.id("word")).getText();
			System.out.println("Text: " + text);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// Close the browser
			driver.quit(); // Close all windows/tabs
		}

	}
}
