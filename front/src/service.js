const getBooks = (query) => {
    const serviceUrl = 'http://localhost:8084/graphql';
    const headers = {
        'Content-Type': 'application/graphql',
        method: "POST",
        body: JSON.stringify({ query }),
    };
    return fetch(serviceUrl, headers)
            .then(response => response.json())
            .then(responseData => responseData.data.books)
            .catch(err => console.error(err));
};

export default getBooks;