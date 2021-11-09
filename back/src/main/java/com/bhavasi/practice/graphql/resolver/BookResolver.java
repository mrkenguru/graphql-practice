package com.bhavasi.practice.graphql.resolver;

import com.bhavasi.practice.graphql.entity.Book;
import com.bhavasi.practice.graphql.mapper.SortMapper;
import com.bhavasi.practice.graphql.model.SortBy;
import com.bhavasi.practice.graphql.repository.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class BookResolver implements GraphQLQueryResolver {

    private final BookRepository bookRepository;
    private final SortMapper sortMapper;

    public Book book(String isbn) {
        return bookRepository.findById(isbn).orElseThrow();
    }

    public List<Book> books(String filter, int countPerPage, SortBy sortBy) {
        Pageable pagination = PageRequest.ofSize(countPerPage).withSort(sortMapper.map(sortBy));

        return bookRepository.findByFilter(filter, pagination);
    }
}
