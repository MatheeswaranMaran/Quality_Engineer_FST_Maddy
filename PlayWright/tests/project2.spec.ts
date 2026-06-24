import { test, expect } from "@playwright/test";

test.beforeEach("Verify Login", async ({ page }) => {
    // Go to the page
    await page.goto("/inventory.html");

    // Assert whether it has logged in
    await expect(page.getByText("Products")).toBeVisible();
})

test("Verify Products", async ({ page }) => {
    // Click on the Fourth product
    await page.locator(".inventory_item_label a").nth(3).click();

    // Print that we came to the fourth product
    console.log("Fourth Product Opened");

    // Verify the Details
    expect(page.getByAltText("Sauce Labs Fleece Jacket")).toBeVisible();
    expect(page.locator(".inventory_details_name")).toContainText("Sauce Labs Fleece Jacket");
    expect(page.locator(".inventory_details_price")).toContainText("$49.99");

    // Go back to the products page
    await page.getByRole("button", { name: "Back to products" }).click();

    // Print that we came to the products page
    console.log("Product Page");

    // Click on the Third Product
    await page.locator(".inventory_item_label a").nth(2).click();

    console.log("Third Product Opened");

    //  Verify the Details
    expect(page.getByAltText("Sauce Labs Bolt T-Shirt")).toBeVisible();
    expect(page.locator(".inventory_details_name")).toContainText("Sauce Labs Bolt T-Shirt");
    expect(page.locator(".inventory_details_price")).toContainText("$15.99");
})

test("Checkout flow", async ({ page }) => {
    // Click the products add to cart button
    await page.getByRole("button", { name: "Add to cart" }).nth(0).click();
    let firstPrice = await page.locator(".inventory_item_price").nth(0).textContent();
    let price = parseFloat(firstPrice!.replace("$", ""));
    console.log(price);
    await page.getByRole("button", { name: "Add to cart" }).nth(0).click();
    let sp = await page.locator(".inventory_item_price").nth(1).textContent();
    price += parseFloat(sp!.replace("$", ""));

    console.log(price);

    // Click the cart button
    await page.locator(".shopping_cart_link").click();

    // Click on the checkout button
    await page.getByRole("button", { name: "Checkout" }).click();

    // Fill the details
    await page.getByRole("textbox", { name: "First Name" }).fill("Maddy");
    await page.getByRole("textbox", { name: "Last Name" }).fill("Wiz");
    await page.getByRole("textbox", { name: "Zip/Postal Code" }).fill("123123");

    // Clickthe Continue button
    await page.getByRole("button", { name: "Continue" }).click();

    // Calculate the tax
    let tax = (price * 0.0801).toFixed(2);
    let floatTax = parseFloat(tax);
    console.log(floatTax);

    // Calculate the total price
    let totalPrice = floatTax + price;
    console.log(totalPrice);

    // Verify the total price
    await expect(page.locator(".summary_total_label")).toContainText(totalPrice.toString());

    // Click the finish button
    await page.getByRole("button", { name: "Finish" }).click();

    // Verify the confirm message
    expect(page.locator(".complete-header")).toContainText("Thank you for your order!");
})

test("Logout", async ({ page }) => {
    // Click the menu page
    await page.getByRole("button", { name: "Open Menu" }).click();

    // Click the log out button
    await page.getByRole("link", { name: "Logout" }).click();

    // Verify that we logged out
    await expect(page.locator(".form_column")).toBeVisible();
})

