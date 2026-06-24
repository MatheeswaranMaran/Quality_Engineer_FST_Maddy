package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps extends BaseClass {
	@Given("The user has opened the TS homepage")
	public void openTSHomepage() {
		// Open the TS Homepage
		driver.get("https://training-support.net");
	}

	@When("they click the About Us link")
	public void clickAboutUs() {
		driver.findElement(By.linkText("About Us")).click();
	}

	@Then("they are redirected to the About Us Page")
	public void verifyPageRedirect() {
		// Explicitly wait to get the page
		wait.until(ExpectedConditions.titleIs("About Training Support"));

		// Asserting whether the page is opened
		assertEquals(driver.getTitle(), "About Training Support");

	}
}
