package Examples;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {
	WebDriver d;

	@BeforeClass
	public void setUp() {
		d = new FirefoxDriver();
		d.get("https://training-support.net/");
	}

	@Test(priority = 1)
	public void verifyPageTitle() {
		// Assertion Statements
		assertEquals(d.getTitle(), "Training Support");
	}

	@AfterClass
	public void tearDown() {
		d.quit();
	}

}
