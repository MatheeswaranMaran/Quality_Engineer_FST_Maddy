package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity2 {

	public static void main(String[] args) throws InterruptedException {
		// Create an instance of WebDriver
		WebDriver driver = new FirefoxDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// Initializing the wait object
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));

		try {
			// Open the test page
			driver.get("https://training-support.net/webelements/login-form");

			// Printing the title of the first page
			System.out.println("The Title of the page is: " + driver.getTitle());

			// Giving the inputs to the fields using sendKeys
			driver.findElement(By.id("username")).sendKeys("admin");

			driver.findElement(By.id("password")).sendKeys("password");

			// Clicking the submit button using cssSelector and click function
			driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();

			// Printing the title of the second page
			System.out.println("The Title of the New Page is: " + driver.getTitle());

			// Explicitly making it wait by giving the locator
			w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.text-emerald-500")));

			// Verification
			String success = driver.findElement(By.cssSelector("h1.text-emerald-500")).getText();

			// Printing the success message
			System.out.println(success);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// Close the browser
			driver.quit();// Close all windows/tabs
		}

	}

}
