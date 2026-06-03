interface Book {
    title: String;
    readonly author: String;
    year?: number;
}

const Sherlock: Book = {
    title: "Sherlock Holmes",
    author: "Arthur Conan Doyle",
    year: 1983
};

const library: Book[] = [
    Sherlock,
    {
        title: "Harry Potter",
        author: "J. K. Rowling"
    }
]

console.log(library);