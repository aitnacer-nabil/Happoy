package com.nabilaitnacer.categoryservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
@Schema(
        name = "Error Response",
        description = "Schema for Error Response"
)
public class ErrorResponseDto {
    @Schema(
            name = "apiPath",
            description = "The path of the API that caused the error",
            example = "/api/v1/categories"
    )
    private String apiPath;
    @Schema(
            name = "errorMessage",
            description = "The error message",
            example = "Category not found"
    )
    private String errorMessage;
    @Schema(
            name = "errorCode",
            description = "The error code",
            example = "404"
    )
    private HttpStatus errorCode;
    @Schema(
            name = "errorTime",
            description = "The time of the error",
            example = "2021-08-01T12:00:00"
    )
    private LocalDateTime errorTime;




}
