import { test, expect } from "@playwright/test";

test('drag and drop', async ({ page }) => {
    // Go to the page
    await page.goto("https://training-support.net/webelements/drag-drop");

    // Print the title
    console.log(await page.title());

    // Ball Element
    const ball = page.getByTestId("ball");
    ball.dragTo(page.getByTestId("dropzone1"));

    // Assert the situation
    await expect(page.getByText("Dropped!")).toContainText("Dropped!");

    const dropzone2 = page.getByTestId("dropzone2");

    ball.dragTo(dropzone2);

    // Assert
    await expect(dropzone2).toContainText("Dropped!");
})