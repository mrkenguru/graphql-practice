package com.bhavasi.practice.graphql.model;

import lombok.Data;

@Data
public class SortBy {
    SortDirection direction;
    String field;
}
