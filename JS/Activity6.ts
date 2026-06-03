function sanitizeInput(input: string): string {
    // Remove leading and trailing whitespace
    const trimmed = input.trim();

    // Escape HTML special characters
    return trimmed
        .replace(/&/g, "&amp;")
        .replace(/</g, "&lt;")
        .replace(/>/g, "&gt;")
        .replace(/"/g, "&quot;")
        .replace(/'/g, "&#39;");
}

// Example user input
const rawInput = `  <script>alert("Hacked!")</script>  `;

// Sanitize the input
const safeInput = sanitizeInput(rawInput);

// Print results
console.log("Original Input:");
console.log(rawInput);

console.log("\nSanitized Input:");
console.log(safeInput);