package project;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ProjectActivity4 {
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
	public void scrollToList() {
		// Scroll Object
		String scroll = "UiScrollable(UiSelector().scrollable(true))";

		// Wait until the page is opened
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"WebElements\"]")));

//		driver.findElement(AppiumBy.androidUIAutomator(scroll + ".flingToEnd(5)"));
		driver.findElement(AppiumBy.androidUIAutomator(scroll + ".flingForward().getChildByText(className(\"android.widget.TextView\"), \"To-Do List\")"));

		// Locate element
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]")).click();

		// Wait until the page opens
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Todo List\"]")));

		// Assert the heading
		assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Todo List\"]")).getText(),
				"Todo List");
	}

	@DataProvider(name = "tasksDesc")
	public Object[][] tasks() {
		return new Object[][] { { "Add tasks to list" }, { "Get number of tasks" }, { "Clear the list" } };
	}

	static int count = 0;

	@Test(dataProvider = "tasksDesc", dependsOnMethods = "scrollToList")
	public void addTasks(String task) {
		// Locate the input field
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]")).sendKeys(task);
		// Click the add button
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"todo-add\"]")).click();

		// Wait until the task is added
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"" + task + "\"]")));

		// Get the list of Web elements
		List<WebElement> tasks = driver
				.findElements(AppiumBy.xpath("//android.view.View//android.view.View//android.widget.TextView"));

		// Text of the web elements
		List<String> tasksDesc = new ArrayList<>();

		// Add the tasks
		for (WebElement t : tasks) {
			tasksDesc.add(t.getText());
		}

		count = tasksDesc.size();

		// Assert whether it contains the task
		assertTrue(tasksDesc.contains(task));

	}

	@Test(dependsOnMethods = "addTasks")
	public void selectTasks() {
		for (int i = 1; i <= count; i++) {
			driver.findElement(AppiumBy.xpath(
					"//android.widget.ListView/android.view.View[" + i + "]/android.view.View/android.widget.CheckBox"))
					.click();
		}

		// Assert the count of the tasks
		assertEquals(count, 5);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
