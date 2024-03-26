package com.nabilaitnacer.categoryservice.exception;

/**
 * GlobalExceptionHandler class for handling global exceptions.
 * This class extends ResponseEntityExceptionHandler and is annotated with @ControllerAdvice to provide global exception handling.
 * It provides methods to handle different types of exceptions and return appropriate HTTP status codes and error messages.
 *
 * @author aitnacer-nabil
 */
public class CategoryAlreadyExistsException extends RuntimeException {
    /**
     * Constructs a new CategoryAlreadyExistsException with the specified detail message.
     *
     * @param categoryName the name of the category that already exists
     */
    public CategoryAlreadyExistsException(String categoryName) {
        super(String.format("Category with name %s already exists", categoryName));
    }
}
