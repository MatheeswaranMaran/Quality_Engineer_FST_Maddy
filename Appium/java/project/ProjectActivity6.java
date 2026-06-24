package project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ProjectActivity6 {
	AndroidDriver driver;
	WebDriverWait wait;

	private final PointerInput finger = new PointerInput(Kind.TOUCH, "finger");

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
	public void scrollToPopups() {
		// Scroll Object
		String scroll = "UiScrollable(UiSelector().scrollable(true))";

		// Wait until the page is opened
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"WebElements\"]")));

//		driver.findElement(AppiumBy.androidUIAutomator(scroll + ".flingToEnd(5)"));
		driver.findElement(AppiumBy.androidUIAutomator(
				scroll + ".scrollForward(3).getChildByText(className(\"android.widget.TextView\"), \"Popups\")"));

		// Locate element
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Popups\"]")).click();

		// Wait until the page opens
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Popups\"]")));

		// Assert the heading
		assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Popups\"]")).getText(),
				"Popups");
	}

	public void doClick(AppiumDriver driver, Point start) {
		Sequence clickPopup = new Sequence(finger, 1);
		clickPopup.addAction(new Pause(finger, Duration.ofMillis(500)));
		clickPopup.addAction(
				finger.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), start.getX(), start.getY()));
		clickPopup.addAction(finger.createPointerDown(0));
		clickPopup.addAction(new Pause(finger, Duration.ofMillis(100)));
		clickPopup.addAction(finger.createPointerUp(0));

		driver.perform(Arrays.asList(clickPopup));
	}

	@Test(dependsOnMethods = "scrollToPopups")
	public void clickPopup() {
		// Locate the popup button and click
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"launcher\"]")).click();

		// Find the Dimensions
		Dimension dims = driver.manage().window().getSize();

		// Create the point
		Point popup = new Point((int) (0.44 * dims.getWidth()), (int) (0.25 * dims.getHeight()));

		// Click the popup
		doClick(driver, popup);

		// Locate the username and password
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");

		// Locate the submit button to click
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();

		// Wait until the success page shows
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Success!\"]")));

		// Assert whether the page is opened
		assertEquals(
				driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Success!\"]")).getText(),
				"Login Success!");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
