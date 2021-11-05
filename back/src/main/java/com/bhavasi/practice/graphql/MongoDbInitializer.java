package com.bhavasi.practice.graphql;

import com.bhavasi.practice.graphql.entity.Book;
import com.bhavasi.practice.graphql.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor
@Component
public class MongoDbInitializer {
    private final DataFactory dataFactory = new DataFactory();
    private final BookRepository bookRepository;

    public void init() {
        try {
            bookRepository.deleteAll();

            List<Book> books = IntStream.range(0, 100).boxed().map(i -> createBook()).collect(Collectors.toList());
            bookRepository.saveAll(books);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Book createBook() {
        String isbn = dataFactory.getNumberText(13);
        String title = IntStream.rangeClosed(2, 2 + dataFactory.getNumberUpTo(5)).boxed()
                                .map(i -> dataFactory.getRandomWord())
                                .collect(Collectors.joining(" "));
        String publisher = dataFactory.getBusinessName();
        List<String> authors = IntStream.rangeClosed(0, dataFactory.getNumberUpTo(2)).boxed()
                                        .map(i -> dataFactory.getName())
                                        .collect(Collectors.toList());
        String publishedDate = String.valueOf(dataFactory.getNumberBetween(1975, 2020));
        return new Book(isbn, capitalize(title), publisher, authors, publishedDate);
    }

    private String capitalize(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return Character.toTitleCase(str.charAt(0)) + str.substring(1);
    }
}
