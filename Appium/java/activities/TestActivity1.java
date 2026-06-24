package activities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class TestActivity1 {
	// Declare the objects
	AppiumDriver driver;

	// Explicit Wait
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Set the file path
		File testApp = new File("src/test/resources/Calculator.apk");

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
	}

	@BeforeMethod
	public void clearResults() {
		// Locate the clear button and click it
		driver.findElement(AppiumBy.accessibilityId("clear")).click();
	}

	@Test
	public void testMethod() {

		// Locate the element 8 and click it
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_8")).click();

		// Locate the element 9 and click it
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_9")).click();

		// Locate the element * and click it
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();

		// Locate the element 2 and click it
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2")).click();

		// Locate the element 2 and click it
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2")).click();
		
		// Locate the element = and click it
		driver.findElement(AppiumBy.accessibilityId("equals")).click();

		// Locate the answer and print it
		String result = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();

		System.out.println(result);
	}

	@AfterClass
	public void tearDown() {
		// Close the application
		driver.quit();
	}

}
