import React from 'react';

const BookInfo = ({ book }) => (
    <li className="list-group-item" key={book.isbn}>
        <div className="d-flex justify-content-between align-items-center">
            <div className="d-flex flex-column">
                <span className="h5 text-primary">{book.title}</span>
                <p className="small">{book.publisher}, {book.publishedDate}</p>
            </div>
            <div className="d-flex flex-column text-end">
            {(book.authors || []).map(author => (
                <p className="small text-right mb-0 text-secondary" key={author}>{author}</p>
            ))}
            </div>
        </div>
    </li>
);

export default BookInfo;