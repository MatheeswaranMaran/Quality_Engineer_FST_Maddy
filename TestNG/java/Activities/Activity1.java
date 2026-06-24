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

public class Activity1 {
	WebDriver d;
	WebDriverWait w;

	@BeforeClass
	public void setUp() {
		d = new FirefoxDriver();
		w = new WebDriverWait(d,Duration.ofSeconds(3));
		d.get("https://training-support.net/");
	}

	@Test
	public void verifyPageTitle() {
		// Assertion Statements
		assertEquals(d.getTitle(), "Training Support");
	}

	@Test(dependsOnMethods = { "verifyPageTitle" })
	public void clickAboutUs() {
		// Finding the About Us Button
		d.findElement(By.partialLinkText("About")).click();
		
		// Explicitly wait to get the page
		w.until(ExpectedConditions.titleIs("About Training Support"));

		// Asserting whether the page is opened
		assertEquals(d.getTitle(), "About Training Support");
	}

	@AfterClass
	public void tearDown() {
		d.quit();
	}
}
