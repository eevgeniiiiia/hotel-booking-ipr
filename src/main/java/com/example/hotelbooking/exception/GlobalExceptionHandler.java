package com.example.hotelbooking.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException exception) {

        logger.warn("Validation error occurred");

        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                400,
                "Validation error"
        );

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(InvalidHotelException.class)
    public ResponseEntity<ErrorResponse> handleInvalidHotelException(
            InvalidHotelException exception) {

        logger.error("Invalid hotel error: {}", exception.getMessage());

        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                400,
                exception.getMessage()
        );

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(
            Exception exception) {

        logger.error("Unexpected application error", exception);

        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                500,
                "Internal server error"
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
