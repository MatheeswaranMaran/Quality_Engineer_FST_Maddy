function fizzBuzz(n: number): string[] {
    const result: string[] = [];

    for (let i = 1; i <= n; i++) {
        // Check for 15 first, as it is divisible by both 3 and 5
        if (i % 15 === 0) {
            result.push("FizzBuzz");
        } else if (i % 3 === 0) {
            result.push("Fizz");
        } else if (i % 5 === 0) {
            result.push("Buzz");
        } else {
            result.push(i.toString()); // Ensure the array only contains strings
        }
    }

    return result;
}

console.log(fizzBuzz(13));