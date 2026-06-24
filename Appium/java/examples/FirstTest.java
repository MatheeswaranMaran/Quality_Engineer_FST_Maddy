package examples;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class FirstTest {
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

//		// Set the desired capabilities for iOS
//		XCUITestOptions options1 = new XCUITestOptions();
//
//		// Options to select platform
//		options.setPlatformName("ios");
//		options.setAutomationName("XCUITest");
//
//		// Option to install/open the required application
//		options.setApp(testApp.getAbsolutePath());
//
//		// Option to prevent application reset
//		options.noReset();
	}

	@Test
	public void testMethod() {
		// Interactions with the application
		System.out.println("Application Opened");

	}

	@AfterClass
	public void tearDown() {
		// Close the application
		driver.quit();
	}
}
