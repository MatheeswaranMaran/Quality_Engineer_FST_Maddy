package Activities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity9 {
	WebDriver d;

	@BeforeClass
	public void setUp() {
		d = new FirefoxDriver();
		d.get("https://training-support.net/webelements/alerts");
	}

	@Test
	public void verifyTitle() {
		assertEquals(d.getTitle(), "Selenium: Alerts");
	}

	@Test
	public void simpleAlertTestCase() {
		// Locating the simple alert button
		d.findElement(By.id("simple")).click();

		// Switching the controls to alert
		Alert a = d.switchTo().alert();

		// Clicking the OK button
		a.accept();

		// Getting the result text
		String result = d.findElement(By.id("result")).getText();

		// Asserting the condition for simple alert
		assertEquals(result, "You just accepted a simple alert!");
	}

	@Test
	public void confirmationAlertTestCase() {
		// Locating the confirmation alert button
		d.findElement(By.id("confirmation")).click();

		// Switching the controls to alert
		Alert a = d.switchTo().alert();

		// Clicking the OK button
		a.accept();

		// Getting the result text
		String result = d.findElement(By.id("result")).getText();

		// Asserting the condition for confirmation alert
		assertEquals(result, "You just accepted a confirmation alert!");
	}

	@DataProvider(name = "Prompt")
	public Object[][] prompt() {
		return new Object[][] {{"Hi Maddy"},{"Hi Abisankar"},{"Hi Arjun"}};
		
	}

	@Test(dataProvider = "Prompt")
	public void promptAlertTestCase(String prompt) {
		// Locating the prompt alert button
		d.findElement(By.id("prompt")).click();

		// Switching the controls to alert
		Alert a = d.switchTo().alert();

		// Prompting text into the prompt
		a.sendKeys(prompt);

		// Clicking the OK button
		a.accept();

		// Getting the result text
		String result = d.findElement(By.id("result")).getText();

		// Asserting the condition for confirmation alert
		assertEquals(result, "You typed \""+ prompt +"\" into the prompt!");

	}

	@AfterClass
	public void tearDown() {
		d.quit();
	}
}
