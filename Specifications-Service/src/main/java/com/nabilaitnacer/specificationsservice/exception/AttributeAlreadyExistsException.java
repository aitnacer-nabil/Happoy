package com.nabilaitnacer.specificationsservice.exception;


public class AttributeAlreadyExistsException extends RuntimeException {

    public AttributeAlreadyExistsException(String categoryName) {
        super(String.format("Category with name %s already exists", categoryName));
    }
}
