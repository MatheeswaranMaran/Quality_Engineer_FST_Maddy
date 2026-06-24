package Activities;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Activity10 {
	WebDriver d;
	WebDriverWait w;

	@BeforeClass
	public void setUp() {
		// Initializing the Driver
		d = new FirefoxDriver();

		// Initializing the explicit wait
		w = new WebDriverWait(d, Duration.ofSeconds(5));

		// Open the page
		d.get("https://training-support.net/webelements/simple-form");
	}

	@DataProvider(name = "csvData")
	public Object[][] inputData() throws IOException, CsvException {
		// Create the object of OpenCSV
		CSVReader r = new CSVReader(new FileReader("src/test/resources/text.csv"));

		// Take all the data without the first line
		r.skip(1);

		// Read the data from the CSV File
		List<String[]> input = r.readAll();
		r.close();

		// Create the input data set
		// This object is passed as DataProvider in the test function
		Object[][] data = new Object[input.size()][];
		
		// Put the data into the data set
		for(int i = 0;i<input.size();i++) {
			data[i] = input.get(i);
		}
		
		System.out.println(data);
		
		return data;
	}

	@Test
	public void verifyTitle() {
		assertEquals(d.getTitle(), "Selenium: Simple Form");
	}

	@Test(dataProvider = "csvData")
	public void formTest(String[] rows) {
		// Sending the data into the form elements
		d.findElement(By.id("full-name")).sendKeys(rows[0]);
		d.findElement(By.id("email")).sendKeys(rows[1]);
		d.findElement(By.name("event-date")).sendKeys(rows[2]);
		d.findElement(By.id("additional-details")).sendKeys(rows[3]);
		
		//Clicking the button submit
		d.findElement(By.cssSelector("button.font-bold")).click();
		
		//Explicitly wait till the success message come
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
		
		// Get the expected result
		String msg = d.findElement(By.id("action-confirmation")).getText();
		
		// Assert the results
		assertEquals(msg,"Your event has been scheduled!");
	}
	
	@AfterMethod
	public void reset() {
		d.navigate().refresh();
	}

	@AfterClass
	public void tearDown() {
		d.quit();
	}
}
