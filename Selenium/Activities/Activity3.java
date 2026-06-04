package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) {
		// Create an instance of WebDriver
		WebDriver driver = new FirefoxDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		try {
			// Open the test page
			driver.get("https://training-support.net/webelements/login-form");

			// Using the XPATH for giving the inputs and clicking the submit button
			driver.findElement(By.xpath("//input[@placeholder = 'Username']")).sendKeys("admin");

			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("password");

			driver.findElement(By.xpath("//button[text()='Submit']")).click();

			// Verification using the xpath locator
			String success = driver.findElement(By.xpath("//h1[contains(@class,'text-emerald-500')]")).getText();

			// Verification using the cssSelector locator
			String success1 = driver.findElement(By.cssSelector("h1.text-emerald-500")).getText();

			// Printing the success messages
			System.out.println(success);

			System.out.println(success1);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// Close the browser
			driver.quit(); // Close all windows/tabs
		}

	}

}
