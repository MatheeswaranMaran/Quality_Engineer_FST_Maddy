function getEvenSquares(numbers: number[]): number[] {
    return numbers.filter(num => num % 2 === 0).map(num => num * num);
}

let input = [2, 4, 5, 6, 7, 8];
console.log(getEvenSquares(input));