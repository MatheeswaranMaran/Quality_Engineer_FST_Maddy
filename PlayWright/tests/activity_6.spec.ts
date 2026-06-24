import { test, expect } from '@playwright/test';

test.beforeEach(async ({ page }) => {
    // Open the test page
    await page.goto("https://training-support.net/webelements/tabs");

    // Assert
    await expect(page).toHaveTitle("Selenium: Tab Opener");
})

test("Handling Tabs", async ({ context, page }) => {
    // Event Handler for the new page
    const newPagePromise = context.waitForEvent('page');

    // Click the button to open a new tab
    await page.getByRole("button", { name: 'Open a new tab' }).click();

    // Wait for the new page to open
    const newPage = await newPagePromise;
    await newPage.waitForEvent('load');

    // Print the code onthe new page
    let word = newPage.locator('span.font-bold');
    console.log(await word.textContent());

    // Assertion
    expect(word).toBeVisible();
})