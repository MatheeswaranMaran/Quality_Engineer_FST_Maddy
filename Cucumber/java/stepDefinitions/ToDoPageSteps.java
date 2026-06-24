package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ToDoPageSteps extends BaseClass {
	@Given("user is on the To-Do list page")
	public void openToDoListPage() {
		// Opening the to-do list page
		driver.get("https://training-support.net/webelements/todo-list");
	}

	@When("user adds the following tasks")
	public void add(DataTable tasksTable) {
		// Converting the DataTable to List
		List<String> tasks = tasksTable.asList();

		// Iterating the list to send the tasks
		for (String task : tasks) {
			// Locating the to-do input
			driver.findElement(By.id("todo-input")).sendKeys(task);
			// Locating the tick button
			driver.findElement(By.id("todo-add")).click();
		}
	}

	@Then("they can see the task added to the list")
	public void see() {
		// Get all the tasks
		List<WebElement> tasks = driver.findElements(By.cssSelector("li.w-full"));

		// Assert the total number of tasks
		assertEquals(tasks.size(), 5);
	}
}
