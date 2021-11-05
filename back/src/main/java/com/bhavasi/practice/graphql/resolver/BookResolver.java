package com.bhavasi.practice.graphql.resolver;

import com.bhavasi.practice.graphql.entity.Book;
import com.bhavasi.practice.graphql.repository.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class BookResolver implements GraphQLQueryResolver {

    private final BookRepository bookRepository;

    public Book book(String id) {
        return bookRepository.findById(id).orElseThrow();
    }

    public List<Book> books() {
        return bookRepository.findAll();
    }
}
