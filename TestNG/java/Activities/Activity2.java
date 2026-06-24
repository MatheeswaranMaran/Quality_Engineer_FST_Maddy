package Activities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver d;

	@BeforeClass
	public void setUp() {
		d = new FirefoxDriver();
		d.get("https://training-support.net/webelements/target-practice");
	}

	@Test
	public void verifyPageTitle() {
		// Asserting the title page is same
		assertEquals(d.getTitle(), "Selenium: Target Practice");
	}

	@Test
	public void falseFindElement() {
		// Wrong Assertion where Black is not present in the page
		assertEquals(d.findElement(By.cssSelector("button.text-slate-900")).getText(), "Black");
	}

	// Using (enabled = false)
	@Test(enabled = false)
	public void useEnabledFalse() {
		// Asserting the text of the yellow button
		assertEquals(d.findElement(By.cssSelector("button.text-yellow-900")).getText(), "Yellow");
	}

	// Using the SkipException
	@Test
	public void useSkipException() {
		// Throwing the SkipException
		throw new SkipException("Reason: We are using an example SkipException");
	}

	@AfterClass
	public void tearDown() {
		d.quit();
	}
}
