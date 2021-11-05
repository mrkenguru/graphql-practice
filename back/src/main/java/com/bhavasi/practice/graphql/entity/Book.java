package com.bhavasi.practice.graphql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private String isbn;

    private String title;
    private String publisher;
    private List<String> authors;
    private String publishedDate;

}
