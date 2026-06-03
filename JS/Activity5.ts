type ApiResponse = {
    id: number,
    name: string,
    status: string
};

function fetchData(): Promise<ApiResponse> {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve({
                id: 1,
                name: "Maddy",
                status: "Success"
            });
        }, 2000);
    });
}

async function getData(): Promise<void> {
    const data = await fetchData();
    console.log(data);
}

getData();