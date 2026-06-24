package project;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import activities.ActionsBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ProjectActivity2 {
	// Declare the objects
	AppiumDriver driver;

	// Explicit Wait
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Set the file path
		File testApp = new File("src/test/resources/ToDo.apk");

		// Set the desired capabilities
		UiAutomator2Options options = new UiAutomator2Options();

		// Options to select platform
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");

		// Option to install/open the required application
		options.setApp(testApp.getAbsolutePath());

		// Option to prevent application reset
		options.noReset();

		// Set the Appium server URL
		URL serverURL = new URI("http://127.0.0.1:4723").toURL();

		// Initialize the driver
		driver = new AndroidDriver(serverURL, options);

		// Explicit wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	@Test
	public void addCategory() {
		// Locate the category bar
		driver.findElement(AppiumBy.id("ListSpinnerCategory")).click();

		// Wait until the edit categories button show
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]"))).click();

		// Wait until the categories page opens
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("CategoryListButtonNew"))).click();

		// Wait until the input text appears
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("CategoryListItemID")))
				.sendKeys("Category");

		// Click the ok button
		driver.findElement(AppiumBy.id("CategoryListButtonOK")).click();

		// Wait until the home page shows
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.CheckedTextView[@text=\"Unfiled\"]")));

		// Assert whether the category is created
		assertEquals(
				driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@text=\"Category\"]")).getText(),
				"Category");
	}

	@Test
	public void selectCategory() {
		// Click the All Button
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@text=\"Unfiled\"]")).click();

		// Wait until the home page comes
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("ToDoEditDescription")));

		// Perform the Long Press
		// Get the size of the screen
		Dimension dims = driver.manage().window().getSize();

		// Calculate where to long press
		Point press = new Point((int) (0.15 * dims.getWidth()), (int) (0.19 * dims.getHeight()));

		// Perform long press
		new ActionsBase().doLongPress(driver, press);

		// Wait until the Activity2 opens
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("DetailSpinnerCategory"))).click();

		// Wait until the new category pops up
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.CheckedTextView[@text=\"Category\"]")))
				.click();

		// Click the ok button
		driver.findElement(AppiumBy.id("DetailButtonOK")).click();

		// Wait until the page comes
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("ToDoEditDescription")));

		// Click the category drop down
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/ListSpinnerCategory")).click();

		// Click the category button
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@text=\"Category\"]")).click();

		// Wait until the page shows
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("ToDoEditDescription")));

		// Assert whether the Activity 2 shows
		assertEquals(driver.findElement(AppiumBy.id("ToDoEditDescription")).getText(), "Activity2");
	}

	@AfterClass
	public void tearDown() {
		// Close the application
		driver.quit();
	}

}
