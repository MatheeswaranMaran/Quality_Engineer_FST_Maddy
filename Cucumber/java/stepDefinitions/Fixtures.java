package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Fixtures extends BaseClass {
	@BeforeAll
	public static void setUp() {
		// Initializing the drivers
		driver = new FirefoxDriver();

		// Explicit wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	@AfterAll
	public static void tearDown() {
		// Close the browser
		driver.quit();
	}
}
