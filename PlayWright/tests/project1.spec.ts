import { test, expect } from "@playwright/test";

test.beforeEach("Verify Login", async ({ page }) => {
    // Go to the page
    await page.goto("/inventory.html");

    // Assert whether it has logged in
    await expect(page.getByText("Products")).toBeVisible();
})

test("Logout", async ({ page }) => {
    // Click the menu page
    await page.getByRole("button", { name: "Open Menu" }).click();

    // Click the log out button
    await page.getByRole("link", { name: "Logout" }).click();

    // Verify that we logged out
    await expect(page.locator(".form_column")).toBeVisible();
})