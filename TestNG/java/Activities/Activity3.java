package Activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver d;
	WebDriverWait w;

	@BeforeClass
	public void setUp() {
		d = new FirefoxDriver();
		w = new WebDriverWait(d, Duration.ofSeconds(5));
		d.get("https://training-support.net/webelements/login-form");

	}

	@Test(priority = 1)
	public void verifyPageTitle() {
		// Asserting the title page is same
		assertEquals(d.getTitle(), "Selenium: Login Form");
	}

	@Test(priority = 2)
	public void validLoginTest() {
		// Giving the inputs to the fields using sendKeys
		d.findElement(By.id("username")).sendKeys("admin");

		d.findElement(By.id("password")).sendKeys("password");

		// Clicking the submit button using cssSelector and click function
		d.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();

		// Explicitly waiting for the change of the page
		w.until(ExpectedConditions.titleIs("Selenium: Login Success!"));

		// Asserting the title page is same
		assertEquals(d.getTitle(), "Selenium: Login Success!");

	}

	@AfterClass
	public void tearDown() {
		d.quit();
	}

}
