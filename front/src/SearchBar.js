import { AiOutlineSortAscending, AiOutlineSortDescending } from "react-icons/ai";


const SearchBar = ({ 
    filter, countPerPage, sortBy, onFilterChange, onCountPerPageChange, onSortFieldChange, onSortDirectionChange,
}) => {
return (
    <div className="d-flex align-items-center bg-light px-3 py-2 small rounded-3 mb-1 ">
        <div className="d-flex align-items-center flex-fill">
            <label htmlFor="filter" className="me-2 fw-bold text-secondary">Search</label>
            <input 
                id="filter"
                type="text"
                value={filter}
                onChange={(event) => onFilterChange(event.target.value)}
                className="form-control form-control-sm me-2" 
            />
        </div>
        <div className="d-flex align-items-center">
            <label htmlFor="countPerPage" className="me-2 fw-bold text-secondary">Show</label>
            <input 
                id="countPerPage"
                type="number"
                min="1"
                max="100"
                value={countPerPage}
                onChange={(event) => onCountPerPageChange(event.target.value)}
                className="form-control form-control-sm text-center me-2" 
            />
        </div>
        <div className="d-flex align-items-center text-secondary">
            <label htmlFor="countPerPage" className="me-2 fw-bold text-nowrap">Sort by</label>
            <select className="form-select form-select-sm" onChange={(event) => onSortFieldChange(event.target.value)}>
                <option value="title">Title</option>
                <option value="publishedDate">Published date</option>
                <option value="publisher">Publisher</option>
            </select>
            { sortBy.dir > 0 
                ? <AiOutlineSortAscending onClick={onSortDirectionChange} size="50" /> 
                : <AiOutlineSortDescending onClick={onSortDirectionChange} size="50" /> 
            }
        </div>
    </div>
);
};

export default SearchBar;
