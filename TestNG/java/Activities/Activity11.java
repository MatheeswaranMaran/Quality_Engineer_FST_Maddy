package Activities;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

import com.opencsv.exceptions.CsvException;

public class Activity11 {
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

	public static List<List<String>> readExcel(String filePath) throws FileNotFoundException, IOException {
		// Creating the base list
		List<List<String>> data = new ArrayList<>();

		// Create the Workbook Object
		Workbook excelFile = new XSSFWorkbook(new FileInputStream(filePath));

		// Select the sheet from the workbook
		Sheet sheet1 = excelFile.getSheetAt(0);

		boolean firstRow = true;

		// Iterate through the rows and cells in the sheet
		for (Row rows : sheet1) {

			if (firstRow) {
				firstRow = false;
				continue;
			}

			// Create a temp list to store each row data
			List<String> rowData = new ArrayList<>();

			for (Cell cells : rows) {

				// Read the cell value and add it to the list
				rowData.add(cells.getStringCellValue());

			}

			// Add the rowData to the input data
			data.add(rowData);

		}		

		excelFile.close();

		return data;
	}

	@DataProvider(name = "excelData")
	public Object[][] inputData() throws IOException, CsvException {
		String filepath = "src/test/resources/sample.xlsx";
		List<List<String>> input = readExcel(filepath);

		// Create the input data set
		// This object is passed as DataProvider in the test function
		Object[][] data = new Object[input.size()][];

		// Put the data into the data set
		for (int i = 0; i < input.size(); i++) {
			data[i] = input.get(i).toArray();
		}

		return data;
	}

	@Test
	public void verifyTitle() {
		assertEquals(d.getTitle(), "Selenium: Simple Form");
	}

	@Test(dataProvider = "excelData")
	public void formTest(String[] rows) {
		// Sending the data into the form elements
		d.findElement(By.id("full-name")).sendKeys(rows[0]);
		d.findElement(By.id("email")).sendKeys(rows[1]);
		d.findElement(By.name("event-date")).sendKeys(rows[2].replace("\"",""));
		d.findElement(By.id("additional-details")).sendKeys(rows[3]);

		// Clicking the button submit
		d.findElement(By.cssSelector("button.font-bold")).click();

		// Explicitly wait till the success message come
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));

		// Get the expected result
		String msg = d.findElement(By.id("action-confirmation")).getText();

		// Assert the results
		assertEquals(msg, "Your event has been scheduled!");
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
