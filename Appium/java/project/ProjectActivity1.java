package project;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
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

public class ProjectActivity1 {
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
		//options.noReset();

		// Set the Appium server URL
		URL serverURL = new URI("http://127.0.0.1:4723").toURL();

		// Initialize the driver
		driver = new AndroidDriver(serverURL, options);

		// Explicit wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	@DataProvider(name = "taskdesc")
	public Object[][] desc() {
		return new Object[][] { { "Activity1", "1", "//android.widget.TextView[contains(@text, 'Tomorrow')]" },
				{ "Activity2", "2", "//android.widget.TextView[contains(@text, 'Tomorrow')]" },
				{ "Activity3", "3", "//android.widget.TextView[contains(@text, 'Thursday')]" } };
	}

	@Test(dataProvider = "taskdesc")
	public void addTasks(String desc, String priority, String date) {
		// Locate the New button
		WebElement newButton = driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/ListButtonNew"));

		// Click the new button
		newButton.click();

		// Wait until the page is opening
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextDescription")));

		// Locate the Description and send the desc
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextDescription")).sendKeys(desc);

		// Locate the priority input and send the priority
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextPriority")).clear();
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextPriority"))
				.sendKeys(priority);

		// Locate the due date input
		WebElement dueDate = driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailButtonDueDate"));

		// Click the due date input
		dueDate.click();

		// Wait until the drop down shows
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(date)));

		// Click the due date tomorrow
		driver.findElement(AppiumBy.xpath(date)).click();

		// Locate the OK button
		WebElement ok = driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailButtonOK"));

		// Click the button
		ok.click();

		// Wait until it reaches the Home page
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("ToDoEditDescription")));

		// Get the text to verify
		List<WebElement> tasks = driver.findElements(AppiumBy.id("ToDoEditDescription"));

		// Assert
		List<String> taskTexts = new ArrayList<>();
		for (WebElement task : tasks) {
			taskTexts.add(task.getText());
		}
		System.out.println(taskTexts);
		assertTrue(taskTexts.contains(desc));
	}

	@AfterClass
	public void tearDown() {
		// Close the application
		driver.quit();
	}

}
