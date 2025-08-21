package com.investment.proposal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Global Exception Handler for Investment Management System
 * Spring Boot: Global exception handler for investment system error management
 * This class provides consistent error handling for investment management operations
 * and supports investment system error reporting and debugging capabilities
 */
@ControllerAdvice  // Spring Boot: Controller advice annotation for global exception handling
// Registers this class as a global exception handler for investment system
public class GlobalExceptionHandler {

    /**
     * Handle investment proposal not found exceptions with proper error response
     * Spring Boot: Exception handler for investment proposal not found errors
     * Provides consistent error responses for investment management operations
     * Supports investment system error reporting and debugging workflows
     *
     * @param ex InvestmentProposalNotFoundException for error handling
     *           Specific exception for investment proposal not found scenarios
     * @param request WebRequest for error context and request information
     *                Provides request context for investment error handling
     * @return ResponseEntity with error details and HTTP 404 status
     *         Provides consistent error response for investment proposal not found
     */
    @ExceptionHandler(InvestmentProposalNotFoundException.class)  // Spring Boot: Specific exception handling for investment errors
    public ResponseEntity<Map<String, Object>> handleInvestmentProposalNotFound(
            InvestmentProposalNotFoundException ex, WebRequest request) {
        // Spring Boot: Create error response map for investment proposal not found
        // Provides structured error information for investment system error handling
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.NOT_FOUND.value());
        errorResponse.put("path", request.getDescription(false).replace("uri=", ""));

        // Spring Boot: Return HTTP 404 response with error details for investment error
        // Provides consistent error response for investment proposal not found scenarios
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handle validation errors with detailed error response for investment data
     * Spring Boot: Exception handler for investment data validation errors
     * Provides detailed validation error responses for investment operations
     * Supports investment system error reporting and data quality management
     *
     * @param ex ConstraintViolationException for validation error handling
     *           Specific exception for investment data validation failures
     * @param request WebRequest for error context and request information
     *                Provides request context for investment validation error handling
     * @return ResponseEntity with validation error details and HTTP 400 status
     *         Provides detailed validation error response for investment data issues
     */
    @ExceptionHandler(ConstraintViolationException.class)  // Spring Boot: Validation exception handling for investment errors
    public ResponseEntity<Map<String, Object>> handleValidationErrors(
            ConstraintViolationException ex, WebRequest request) {
        // Spring Boot: Create error response map for investment validation errors
        // Provides structured validation error information for investment system
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", "Investment proposal validation failed");
        errorResponse.put("details", ex.getMessage());
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("path", request.getDescription(false).replace("uri=", ""));

        // Spring Boot: Return HTTP 400 response with validation error details
        // Provides detailed validation error response for investment data issues
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle generic exceptions with proper error response for investment system
     * Spring Boot: Exception handler for generic investment system errors
     * Provides consistent error responses for unexpected investment system issues
     * Supports investment system reliability and error recovery workflows
     *
     * @param ex Exception for generic error handling in investment system
     *           General exception for unexpected investment system errors
     * @param request WebRequest for error context and request information
     *                Provides request context for investment system error handling
     * @return ResponseEntity with error details and HTTP 500 status
     *         Provides consistent error response for investment system failures
     */
    @ExceptionHandler(Exception.class)  // Spring Boot: Generic exception handling for investment system
    public ResponseEntity<Map<String, Object>> handleGenericException(
            Exception ex, WebRequest request) {
        // Spring Boot: Create error response map for generic investment system errors
        // Provides structured error information for unexpected investment system issues
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", "An unexpected error occurred in investment system");
        errorResponse.put("details", ex.getMessage());
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.put("path", request.getDescription(false).replace("uri=", ""));

        // Spring Boot: Return HTTP 500 response with error details for investment system failure
        // Provides consistent error response for unexpected investment system issues
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}