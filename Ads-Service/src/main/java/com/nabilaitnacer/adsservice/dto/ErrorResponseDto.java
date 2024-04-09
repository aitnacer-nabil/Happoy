package com.nabilaitnacer.adsservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * ErrorResponseDto class.
 * This class is used to represent the structure of the error response that is sent when an exception is thrown.
 * It contains information about the API path that caused the error, the error message, the error code, and the time of the error.
 * It is annotated with @Data and @AllArgsConstructor from Lombok to generate getters, setters, toString, equals, hashCode, and a constructor with all arguments.
 * It is also annotated with @Schema from Swagger to provide metadata for the model definition in OpenAPI.
 *
 * @author aitnacer-nabil
 */
@Data @AllArgsConstructor
@Schema(
        name = "Error Response",
        description = "Schema for Error Response"
)
//TODO: Add the necessary schema
public class ErrorResponseDto {
    /**
     * The path of the API that caused the error.
     */
    @Schema(
            name = "apiPath",
            description = "The path of the API that caused the error",
            example = "/api/v1/categories"
    )
    private String apiPath;

    /**
     * The error message.
     */
    @Schema(
            name = "errorMessage",
            description = "The error message",
            example = "Category not found"
    )
    private String errorMessage;
    /**
     * The error code.
     */
    @Schema(
            name = "errorCode",
            description = "The error code",
            example = "404"
    )
    private HttpStatus errorCode;
    /**
     * The time of the error.
     */
    @Schema(
            name = "errorTime",
            description = "The time of the error",
            example = "2021-08-01T12:00:00"
    )
    private LocalDateTime errorTime;




}
