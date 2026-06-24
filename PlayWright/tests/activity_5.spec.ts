import { test, expect } from "@playwright/test";

test.beforeEach('Handling Alerts', async ({ page }) => {
    // Go to the page
    await page.goto("https://training-support.net/webelements/alerts");

    // Assert
    await expect(page).toHaveTitle("Selenium: Alerts");
})

test("Handling Simple Alert", async ({ page }) => {
    // Alert Dialog Handler
    page.on('dialog', async dialog => {
        // Print the message
        console.log(dialog.message());

        // Clicking OK
        await dialog.accept();
    })

    // Clicking the simple alert button
    await page.getByRole("button", { name: "Simple" }).click();

    // Assert the result message
    let message = await page.getByTestId('result').textContent();
    expect(message).toBe("You just accepted a simple alert!");
})

test("Handling Confirmation Alert", async ({ page }) => {
    // Confirmation Alert Handler
    page.on("dialog", async dialog => {
        // Print the message
        console.log(dialog.message());

        // Dismiss the alert
        dialog.dismiss();
    })

    // Clicking the confirmation alert
    await page.getByRole("button", { name: "Confirmation" }).click();

    // Assert the result message
    let message = await page.getByTestId('result').textContent();
    expect(message).toBe("You just dismissed a confirmation alert!");
})

test("Handling Prompt Alert", async ({ page }) => {
    // Prompt Alert Handler
    page.on("dialog", async dialog => {
        // Print the message
        console.log(dialog.message());

        // Clicking Ok after giving the message
        dialog.accept("Hi Maddy");
    })

    // Clicking the prompt alert button
    await page.getByRole("button", { name: "Prompt" }).click();

    // Assert the result message
    let message = await page.getByTestId("result").textContent();
    expect(message).toBe('You typed "Hi Maddy" into the prompt!');
})