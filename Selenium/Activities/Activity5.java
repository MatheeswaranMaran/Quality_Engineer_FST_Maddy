package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {
	public static void main(String[] args) {
		// Create an instance of WebDriver
		WebDriver driver = new FirefoxDriver();

		try {
			// Open the test page
			driver.get("https://training-support.net/webelements/dynamic-controls");

			// Printing the title of the first page
			System.out.println("The Title of the page is: " + driver.getTitle());

			// Find the checkbox element
			WebElement cb = driver.findElement(By.id("checkbox"));

			// Check whether the checkbox is displayed
			System.out.println("Is the checkbox displayed? " + cb.isDisplayed());

			// Click the "Remove Checkbox" button
			driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();

			// Check whether the checkbox is displayed
			System.out.println("Is the checkbox displayed? " + cb.isDisplayed());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// Close the browser
			driver.quit(); // Close all windows/tabs
		}

	}
}
