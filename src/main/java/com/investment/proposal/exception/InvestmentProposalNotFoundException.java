package com.investment.proposal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Investment Proposal Not Found Exception for Error Handling
 * Spring Boot: Custom exception for investment management error scenarios
 * This class provides specific error handling for investment data access failures
 * and supports investment system error reporting and debugging capabilities
 */
@ResponseStatus(HttpStatus.NOT_FOUND)  // Spring Boot: HTTP status mapping for investment errors
// Maps this exception to HTTP 404 status for REST API responses
public class InvestmentProposalNotFoundException extends RuntimeException {

    /**
     * Constructor for investment proposal not found exception with message
     * Spring Boot: Custom exception with error message for investment errors
     * Enables specific investment error handling and reporting capabilities
     * Supports investment system error reporting and debugging workflows
     *
     * @param message Error message for investment proposal not found scenario
     *                Provides detailed error information for debugging and logging
     */
    public InvestmentProposalNotFoundException(String message) {
        // Spring Boot: Call parent constructor with error message for investment exception
        // Initializes investment exception with specific error information
        super(message);
    }

    /**
     * Constructor for investment proposal not found exception with message and cause
     * Spring Boot: Custom exception with error message and cause for investment errors
     * Enables specific investment error handling with root cause information
     * Supports investment system error reporting and debugging with full context
     *
     * @param message Error message for investment proposal not found scenario
     *                Provides detailed error information for debugging and logging
     * @param cause Root cause exception for investment proposal not found error
     *              Provides underlying error information for comprehensive debugging
     */
    public InvestmentProposalNotFoundException(String message, Throwable cause) {
        // Spring Boot: Call parent constructor with message and cause for investment exception
        // Initializes investment exception with error message and root cause information
        super(message, cause);
    }
}