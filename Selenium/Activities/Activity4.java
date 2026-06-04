package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity4 {

	public static void main(String[] args) {
		// Create an instance of WebDriver
		WebDriver driver = new FirefoxDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		try {
			// Open the test page
			driver.get("https://training-support.net/webelements/target-practice");

			System.out.println("The title of the page is: " + driver.getTitle());

			// Text of the 3rd Header
			System.out.println("Text of the 3rd Header is: "
					+ driver.findElement(By.xpath("//h3[contains(@class,'text-3xl')]")).getText());

			// Color of the 5th Header
			WebElement h5 = driver.findElement(By.xpath("//h5[contains(@class,'text-3xl')]"));

			String h5color = h5.getCssValue("color");

			System.out.println("Hex Value of the color of the Heading 5: " + Color.fromString(h5color).asHex());

			System.out.println("RGB Value of the color of the Heading 5: " + Color.fromString(h5color).asRgb());

			System.out.println("RGBA Value of the color of the Heading 5: " + Color.fromString(h5color).asRgba());

			// Find the purple button and print the classes
			WebElement purple = driver.findElement(By.cssSelector("button.text-purple-900"));

			System.out.println(purple.getAttribute("class"));

			// Find the slate button and print the text
			WebElement slate = driver.findElement(By.cssSelector("button.text-slate-900"));

			System.out.println(slate.getText());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// Close the browser
			driver.quit(); // Close all windows/tabs
		}

	}

}
