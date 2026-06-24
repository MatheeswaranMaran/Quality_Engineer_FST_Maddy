package Activities;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice");
	}

	@Test(alwaysRun = true)
	public void verifyPageTitle() {
		// Asserting the title page is same
		assertEquals(driver.getTitle(), "Selenium: Target Practice");
	}

	@Test(groups = { "headingTests" })
	public void headerTest1() {
		// Text of the 3rd Header
		String h3t = driver.findElement(By.xpath("//h3[contains(@class,'text-3xl')]")).getText();
		assertEquals(h3t, "Heading #3");
	}

	@Test(groups = { "headingTests" })
	public void headerTest2() {
		// Color of the 5th Header
		WebElement h5 = driver.findElement(By.xpath("//h5[contains(@class,'text-3xl')]"));

		String h5color = h5.getCssValue("color");

		assertEquals(h5color, "rgb(147, 51, 234)");
	}

	@Test(groups = { "buttonTests" })
	public void purpleButtonClass() {
		// Find the purple button and print the classes
		String purple = driver.findElement(By.cssSelector("button.text-purple-900")).getAttribute("class");

		assertTrue(purple.contains("text-purple-900"));
	}

	@Test(groups = { "buttonTests" })
	public void slateButtonText() {
		// Find the slate button and print the text
		String slate = driver.findElement(By.cssSelector("button.text-slate-900")).getText();

		assertEquals(slate, "Slate");
	}

	@AfterClass(alwaysRun = true)
	public void teardown() {
		driver.quit();
	}
}
