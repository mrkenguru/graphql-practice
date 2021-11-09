import { useEffect, useCallback, useState } from "react";
import { GiBookCover } from "react-icons/gi";

import BookInfo from "./BookInfo";
import query_books from "./query";
import SearchBar from "./SearchBar";
import getBooks from "./service";

const App = () => {
  const [books, setBooks] = useState([]);
  
  const [filter, setFilter] = useState("it");
  const [countPerPage, setCountPerPage] = useState(10);
  const [sortBy, setSortBy] = useState({ field: 'title', dir: 1 });
  
  const fetchData = useCallback(() => {
    const sendRequest = () => getBooks(query_books(filter, countPerPage, sortBy));
    const timeoutId = setTimeout(() => sendRequest().then(setBooks), 500);
    return () => clearTimeout(timeoutId);
  }, [filter, countPerPage, sortBy]);
  
  useEffect(() => fetchData(), [fetchData]);

  return (
    <div className="App container mt-5" >
      <h1 className="text-primary">
        <GiBookCover /> Books
      </h1>
      <SearchBar
        filter={filter}
        onFilterChange={setFilter}
        countPerPage={countPerPage}
        onCountPerPageChange={setCountPerPage}
        sortBy={sortBy}
        onSortFieldChange={(field) => setSortBy(prev => ({ ...prev, field }))}
        onSortDirectionChange={() => setSortBy(prev => ({ ...prev, dir: -1 * prev.dir }))}
      />
      {books && (
        <ul className="list-group list-group-flush">
          { books.map((book) => <BookInfo key={book.isbn} book={book} />) }
        </ul>
      )}
    </div>
  );
}

export default App;
