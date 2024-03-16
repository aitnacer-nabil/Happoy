package com.nabilaitnacer.categoryservice.exception;

import com.nabilaitnacer.categoryservice.dto.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

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
    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleCategoryAlreadyExistsException(CategoryAlreadyExistsException exception, WebRequest request){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                request.getDescription(false),
                exception.getMessage(),
                HttpStatus.CONFLICT,
                LocalDateTime.now()
        );
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponseDto);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseDto> handleDataIntegrityViolationException(DataIntegrityViolationException exception, WebRequest request){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                request.getDescription(false),
                "Category name already exists..",
                HttpStatus.CONFLICT,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponseDto);
    }

}
