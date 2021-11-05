package com.bhavasi.practice.graphql.repository;

import com.bhavasi.practice.graphql.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {

}
