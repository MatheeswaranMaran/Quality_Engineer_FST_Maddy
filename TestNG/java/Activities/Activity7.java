package Activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {

	WebDriver d;
	WebDriverWait w;

	@BeforeClass
	public void setUp() {
		d = new FirefoxDriver();
		w = new WebDriverWait(d, Duration.ofMillis(500));
		d.get("https://training-support.net/webelements/login-form");

	}

	@Test(priority = 1)
	public void verifyPageTitle() {
		// Asserting the title page is same
		assertEquals(d.getTitle(), "Selenium: Login Form");
	}

	@DataProvider(name = "Invalid")
	public Object[][] creds() {
		return new Object[][] { { "username", "password" }, { "admin", "Password" }, { "username", "Password" } };
	}

	@Test(priority = 2, dataProvider = "Invalid")
	public void validLoginTest(String username, String password) {
		Reporter.log("Test Case Started"); // High Level Logging
		// Giving the inputs to the fields using sendKeys
		d.findElement(By.id("username")).sendKeys(username);
		Reporter.log("Username entered"); // Low Level Logging

		d.findElement(By.id("password")).sendKeys(password);
		Reporter.log("Password entered"); // Low Level Logging

		// Clicking the submit button using cssSelector and click function
		d.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
		Reporter.log("Submit Button Clicked"); // Low Level Logging

		// Explicitly wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("subheading")));

		String msg = d.findElement(By.id("subheading")).getText();

		// Asserting the title page is same
		assertEquals(msg, "Invalid credentials");
		Reporter.log("Expected value asserted"); // Low Level Logging
		Reporter.log("Test Case Ended"); // High Level Logging
	}

	@AfterMethod
	public void reStart() {
		d.navigate().refresh();
	}

	@AfterClass
	public void tearDown() {
		d.quit();
	}

}