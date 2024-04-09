package com.nabilaitnacer.adsservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ResourceNotFoundException class for handling not found resources.
 * This class extends RuntimeException and is annotated with @ResponseStatus to return a 404 status code when the exception is thrown.
 * It is used when a resource is not found with the given input data.
 *
 * @author aitnacer-nabil
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
     * ResourceNotFoundException class for handling not found resources.
     * This class extends RuntimeException and is annotated with @ResponseStatus to return a 404 status code when the exception is thrown.
     * It is used when a resource is not found with the given input data.
     *
     * @author aitnacer-nabil
     */
    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue){
        super(String.format("%s not found with the given input data %s : '%s'", resourceName, fieldName, fieldValue));
    }
}
