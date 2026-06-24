package project;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ProjectActivity3 {

	// Driver Initialization
	WebDriver driver;

	// Explicit wait
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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Explicit wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	@Test
	public void completeActivities() {
		// Locate the tick button
		driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[1]/android.widget.CheckBox[@resource-id=\"com.xmission.trevin.android.todo:id/ToDoItemChecked\"]")).click();
		
		driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[1]/android.widget.CheckBox[@resource-id=\"com.xmission.trevin.android.todo:id/ToDoItemChecked\"]")).click();
		
		assertEquals(driver.findElement(AppiumBy.id("ToDoEditDescription")).getText(),"Activity3");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
