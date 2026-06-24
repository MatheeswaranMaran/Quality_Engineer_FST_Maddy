package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps extends BaseClass {
	@Given("the user is on the login page")
	public void openLoginPage() {
		// Opening the login page
		driver.get("https://training-support.net/webelements/login-form");
	}

	@When("the user enters username and password")
	public void dataEntering() {
		// Giving the inputs to the fields using sendKeys
		driver.findElement(By.id("username")).sendKeys("admin");

		driver.findElement(By.id("password")).sendKeys("password");
	}

	@When("the user enters {string} and {string}")
	public void dataEnteringWithoutExamples(String un, String pwd) {
		// Giving the inputs to the fields using sendKeys
		driver.findElement(By.id("username")).sendKeys(un);

		driver.findElement(By.id("password")).sendKeys(pwd);
	}

	@And("clicks the submit button")
	public void clickSubmitButton() {
		// Clicking the submit button using cssSelector and click function
		driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
	}

	@Then("gets the confirmation message and verify it")
	public void verifyLoginPage() {
		// Explicitly waiting for the change of the page
		wait.until(ExpectedConditions.titleIs("Selenium: Login Success!"));

		// Asserting the title page is same
		assertEquals(driver.getTitle(), "Selenium: Login Success!");
	}
	
	@Then("gets the {string} and verify it")
	public void verifyInvalid(String msg) {
		// Explicitly waiting for the change of the page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subheading")));
		
		// Asserting the invalid message
		assertEquals(driver.findElement(By.id("subheading")).getText(),msg);
	}
}
