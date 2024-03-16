package com.nabilaitnacer.categoryservice.exception;

public class CategoryAlreadyExistsException extends RuntimeException {
    public CategoryAlreadyExistsException(String categoryName) {
        super(String.format("Category with name %s already exists", categoryName));
    }
}
