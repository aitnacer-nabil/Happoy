package com.nabilaitnacer.adsservice.exception;

import com.nabilaitnacer.adsservice.dto.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

/**
 * GlobalExceptionHandler class for handling global exceptions.
 * This class extends ResponseEntityExceptionHandler and is annotated with @ControllerAdvice to provide global exception handling.
 * It provides methods to handle different types of exceptions and return appropriate HTTP status codes and error messages.
 *
 * @author aitnacer-nabil
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {
    /**
     * Handles all types of exceptions.
     *
     * @param exception the exception to handle
     * @param request the current web request
     * @return a ResponseEntity containing the error response DTO
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exception, WebRequest request){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                request.getDescription(false),
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now()
        );
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDto);
    }
    /**
     * Handles ResourceNotFoundException.
     *
     * @param exception the exception to handle
     * @param request the current web request
     * @return a ResponseEntity containing the error response DTO
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                request.getDescription(false),
                exception.getMessage(),
                HttpStatus.NOT_FOUND,
                LocalDateTime.now()
        );
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDto);
    }
    /**
     * Handles CategoryAlreadyExistsException.
     *
     * @param exception the exception to handle
     * @param request the current web request
     * @return a ResponseEntity containing the error response DTO
     */
    @ExceptionHandler(AdsAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleCategoryAlreadyExistsException(AdsAlreadyExistsException exception, WebRequest request){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                request.getDescription(false),
                exception.getMessage(),
                HttpStatus.CONFLICT,
                LocalDateTime.now()
        );
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponseDto);
    }
    /**
     * Handles DataIntegrityViolationException.
     *
     * @param exception the exception to handle
     * @param request the current web request
     * @return a ResponseEntity containing the error response DTO
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseDto> handleDataIntegrityViolationException(DataIntegrityViolationException exception, WebRequest request){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                request.getDescription(false),
                "Ads  name already exists..",
                HttpStatus.CONFLICT,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponseDto);
    }

}
