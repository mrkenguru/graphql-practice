package com.bhavasi.practice.graphql.mapper;

import com.bhavasi.practice.graphql.model.SortBy;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class SortMapper {

    private static final String DEFAULT_FIELD = "title";

    public Sort map(SortBy sortBy) {
        Sort.Direction sortDirection = mapDirection(sortBy);
        String sortField = mapField(sortBy);

        return Sort.by(sortDirection, sortField);
    }

    private Sort.Direction mapDirection(SortBy sortBy) {
        switch (sortBy.getDirection()) {
            case ASC:
            default:
                return Sort.Direction.ASC;
            case DESC:
                return Sort.Direction.DESC;
        }
    }

    private String mapField(SortBy sortBy) {
        if (sortBy.getField() == null || "".equals(sortBy.getField())) {
            return DEFAULT_FIELD;
        }
        return sortBy.getField();
    }
}
