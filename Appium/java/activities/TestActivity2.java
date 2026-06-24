package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class TestActivity2 {
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
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test
	public void testMethod() {

		// Open the page in the browser
		driver.get("https://training-support.net");
		
		// Verify the page is opened
		assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text=\"Training Support\"])[1]")).getText(), "Training Support");
		
		// Locate the button "About Us" and click it
		driver.findElement(AppiumBy.accessibilityId("About Us")).click();
		
		// Verify the heading of the About Us page
		assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"About Us\"]")).getText(),"About Us");
	}

	@AfterClass
	public void tearDown() {
		// Close the application
		driver.quit();
	}

}
