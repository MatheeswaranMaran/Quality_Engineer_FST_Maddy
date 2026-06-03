function getCentenaryYear(name: string, age: number): string {
    const currentYear = new Date().getFullYear();
    const yearsUntil100 = 100 - age;
    const centenaryYear = currentYear + yearsUntil100;

    return `Hello ${name}, you will turn 100 in the year ${centenaryYear}.`;
}

console.log(getCentenaryYear("Maddy", 22));