package com.moonlight.project.airBnbApp.advice;

import com.moonlight.project.airBnbApp.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFound(ResourceNotFoundException exception){
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();
        return buildErrorResponseEntity(apiError);
    }

    // NEW: Handle unsupported media type (e.g. sending text/plain instead of application/json)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ApiResponse<?>> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException exception) {
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                .message(exception.getMessage())
                .subErrors(Collections.singletonList("Content-Type header must be 'application/json'"))
                .build();
        return buildErrorResponseEntity(apiError);
    }

    // NEW: Handle malformed JSON or parse errors
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse<?>> handleHttpMessageNotReadable(HttpMessageNotReadableException exception) {
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Malformed JSON request or invalid data format")
                .subErrors(Collections.singletonList(exception.getMessage()))
                .build();
        return buildErrorResponseEntity(apiError);
    }

    // Handle generic exceptions correctly
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleInternalServerError(Exception exception) {
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(exception.getMessage())
                .build();
        return buildErrorResponseEntity(apiError);
    }

    // Helper method
    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse<>(apiError), apiError.getStatus());
    }
}