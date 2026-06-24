import { test, expect } from "@playwright/test";

test('Target Practice', async ({ page }) => {
    // Go to the page
    await page.goto("https://training-support.net/webelements/target-practice");

    // Assert the title
    await expect(page).toHaveTitle("Selenium: Target Practice");

    // 1. Locate the Cyan button
    const cyan_text = await page.getByText("Cyan").textContent();

    // Print the text of the cyan button
    console.log(cyan_text);

    // 2. Locate the 6th Heading and get its classes
    const heading_6 = await page.getByRole("heading", { name: 'Heading #6' }).getAttribute('class');

    // Prin the attributes of the 6th Heading
    console.log(heading_6);

    // 3. Locate the 5th Heading and get its color
    const heading_5 = page.getByRole("heading").filter({ hasText: "Heading #5" });

    // Print the color
    console.log(await heading_5.evaluate((el) => { return window.getComputedStyle(el).color }));

    // 4. Locate the pink button and get its dimensions
    const pink_button_dimensions = await page.getByText("Pink").boundingBox();

    // Print the dimensions
    console.log(pink_button_dimensions);

})