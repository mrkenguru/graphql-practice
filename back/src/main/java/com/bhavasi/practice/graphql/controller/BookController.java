package com.bhavasi.practice.graphql.controller;

import com.bhavasi.practice.graphql.entity.Book;
import com.bhavasi.practice.graphql.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World!");
    }

    @GetMapping("/book")
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> find(@PathVariable String id) {
        return ResponseEntity.ok(bookRepository.findById(id).orElseThrow());
    }
}
