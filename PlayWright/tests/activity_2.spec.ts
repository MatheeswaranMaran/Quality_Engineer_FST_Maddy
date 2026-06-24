import { test, expect } from "@playwright/test";

test("going to form page", async ({ page }) => {
    // Go to the page
    await page.goto("https://training-support.net/webelements/simple-form");

    // Getting the title of the page
    const title = await page.title();

    // Printing the title
    console.log(title);

    // Asserting the title
    await expect(page).toHaveTitle("Selenium: Simple Form");


    // Enter the inputs
    await page.getByRole("textbox", { name: 'full-name' }).fill("Maddy");
    await page.getByRole("textbox", { name: 'Email address' }).fill("m@example.com");
    await page.getByTestId("event-date").fill('2026-07-03');
    await page.getByRole("textbox", { name: 'Additional Details' }).fill("This event is an test");
    await page.getByRole("button", { name: 'Submit' }).click();

    // Get the confirmation message
    const confirm = await page.getByRole("heading").filter({ hasText: 'event' }).textContent();

    // Print the confirmation message
    console.log(confirm);

    // Assert the message
    await expect(page.getByRole("heading").filter({ hasText: "Your" })).toContainText("Your event has been scheduled!");
})