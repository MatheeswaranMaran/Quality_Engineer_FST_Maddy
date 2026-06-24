package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class TestActivity4 extends ActionsBase {
	// Declare the objects
	AppiumDriver driver;

	// Explicit Wait
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Set the desired capabilities
		UiAutomator2Options options = new UiAutomator2Options();

		// Options to select platform
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");

		// Option to install/open the required application
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");

		options.noReset();

		// Set the Appium server URL
		URL serverURL = new URI("http://127.0.0.1:4723").toURL();

		// Initialize the driver
		driver = new AndroidDriver(serverURL, options);

		// Explicit Wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Open the page in the browser
		driver.get("https://training-support.net/webelements/sliders");
	}

	@DataProvider(name = "Inputs")
	public Object[][] inputs() {
		return new Object[][] { { 0.5, 0.72, 0.333, 0.72, 2000, "25%" }, { 0.5, 0.72, 0.667, 0.72, 3000, "75%" } };
	}

	@Test(dataProvider = "Inputs")
	public void testVolumeSlider1(double startX, double startY, double endX, double endY, int duration,
			String expected) {

		// Calculate the phone screen dimensions
		Dimension dims = driver.manage().window().getSize();

		// Calculate the start and end points
		Point start = new Point((int) (startX * dims.getWidth()), (int) (startY * dims.getHeight()));

		Point end = new Point((int) (endX * dims.getWidth()), (int) (endY * dims.getHeight()));

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.SeekBar[@resource-id=\"volume\"]")));
		// resource-id: packageName:id/value

		// Drag the slider from 50 to 25
		new ActionsBase().doSwipe(driver, duration, start, end);	

		// Assert whether the slider worked
		String slided = driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text, '%')]")).getText();

		assertEquals(slided, expected);

	}

	@AfterClass
	public void tearDown() {
		// Close the application
		driver.quit();
	}
}
