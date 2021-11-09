export const query_single_book = `{
    book(isbn: "3413671227435") {
        isbn
        title
        publishedDate
    }
}`;

export const query_books = (filter, countPerPage, sorting) => {
    const sortBy = `{ field: "${sorting.field}", direction: ${sorting.dir > 0 ? 'ASC' : 'DESC'} }`;

    return `{
        books(filter: "${filter}", countPerPage: ${countPerPage}, sortBy: ${sortBy}) {
            isbn
            title
            publisher
            authors
            publishedDate
        }
    }`
};


export default query_books;