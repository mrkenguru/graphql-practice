package com.bhavasi.practice.graphql.repository;

import com.bhavasi.practice.graphql.entity.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    String CONTAINS_FILTER_CI = "{ $regex: /.*?0.*/, $options: 'i' }";

    @Query("{ $or: [ " +
            "{ 'isbn': " + CONTAINS_FILTER_CI + " }, " +
            "{ 'title': " + CONTAINS_FILTER_CI + " }, " +
            "{ 'publisher': " + CONTAINS_FILTER_CI + " }, " +
            "{ 'publishedDate': " + CONTAINS_FILTER_CI + " } ] }")
    List<Book> findByFilter(String filter, Pageable pageable);
}
