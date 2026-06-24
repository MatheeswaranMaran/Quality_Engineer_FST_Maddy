package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertPageSteps extends BaseClass {
	@Given("the user is on the alerts page")
	public void openAlertPage() {
		// Opening the alert page
		driver.get("https://training-support.net/webelements/alerts");
	}

	@When("the user clicks the simple alert button")
	public void clickSimpleAlert() {
		// Locating the simple alert button and click it
		driver.findElement(By.id("simple")).click();
	}

	@When("the user clicks the confirm alert button")
	public void clickConfirmAlert() {
		// Locating the confirm alert button and click it
		driver.findElement(By.id("confirmation")).click();
	}

	@When("the user clicks the prompt alert button")
	public void clickPromptAlert() {
		// Locating the prompt alert button and click it
		driver.findElement(By.id("prompt")).click();
	}

	@And("the user goes to the alert and accepts it")
	public void openAlert() {
		// Switching the controls to the alert
		Alert a = driver.switchTo().alert();

		// Accepting the alert
		a.accept();
	}

	@And("the user goes to the alert and gives {string} and accepts it")
	public void openPromptAlert(String prompt) {
		// Switching the controls to alert
		Alert a = driver.switchTo().alert();

		// Prompting text into the prompt
		a.sendKeys(prompt);

		// Clicking the OK button
		a.accept();
	}

	@Then("checks the simple alert message")
	public void assertSimpleAlert() {
		// Asserting the condition for simple alert
		assertEquals(driver.findElement(By.id("result")).getText(), "You just accepted a simple alert!");
	}

	@Then("checks the confirm alert message")
	public void assertConfirmAlert() {
		// Asserting the condition for confirm alert		
		assertEquals(driver.findElement(By.id("result")).getText(), "You just accepted a confirmation alert!");
	}
	
	@Then("checks the {string} alert message")
	public void assertPromptAlert(String prompt) {
		// Asserting the condition for prompt alert
		assertEquals(driver.findElement(By.id("result")).getText(), "You typed \""+ prompt +"\" into the prompt!");
	}
}
