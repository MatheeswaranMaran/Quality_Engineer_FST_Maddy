package project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ProjectActivity5 {
	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.appls.chrome.Main");
		options.noReset();

		// Server URL
		URL server = new URI("http://127.0.0.1:4723").toURL();

		// Driver initialization
		driver = new AndroidDriver(server, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Open the page
		driver.get("https://training-support.net/webelements");
	}

	@Test(priority = 1)
	public void scrollToLogin() {
		// Scroll Object
		String scroll = "UiScrollable(UiSelector().scrollable(true))";

		// Wait until the page is opened
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"WebElements\"]")));

//		driver.findElement(AppiumBy.androidUIAutomator(scroll + ".flingToEnd(5)"));
		driver.findElement(AppiumBy.androidUIAutomator(
				scroll + ".scrollForward().getChildByText(className(\"android.widget.TextView\"), \"Login Form\")"));

		// Locate element
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]")).click();

		// Wait until the page opens
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]")));

		// Assert the heading
		assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]")).getText(),
				"Login Form");
	}

	@Test(dependsOnMethods = "scrollToLogin")
	public void correctLogin() {
		// Locate the username and password fields
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");

		// Locate the submit button and click it
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();

		// Wait until the success page opens
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Success!\"]")));

		// Assert the success page
		assertEquals(
				driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Success!\"]")).getText(),
				"Login Success!");
		
		// Go back
		driver.navigate().back();		
	}

	@Test(dependsOnMethods = "scrollToLogin")
	public void incorrectLogin() {
		// Locate the username and password fields
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("wrongadmin");

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");

		// Locate the submit button and click it
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();
		
		// Wait until the incorrect credentials pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"subheading\"]")));
		
		// Assert the invalid credentials
		assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"subheading\"]")).getText(),"Invalid credentials");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
