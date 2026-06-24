import { test, expect } from "@playwright/test";

test("has the right title", async ({ page }) => {
    // Go to the page
    await page.goto("https://training-support.net");

    // Check if the title is correct
    await expect(page).toHaveTitle("Training Support");
});

test("has the about us title", async ({ page }) => {
    // Go to the page
    await page.goto("https://training-support.net/about");

    // Check if the title is about us
    await expect(page).toHaveTitle('About Training Support');
})