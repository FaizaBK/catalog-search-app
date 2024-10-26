package fr.faizamnasry.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * A global exception handler for handling application-wide exceptions.
 * This class uses Spring's @ControllerAdvice to centralize exception handling.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles ProfileNotFoundException by returning a 404 response with a custom error message.
     *
     * @param ex      the thrown ProfileNotFoundException
     * @param request the current web request
     * @return a ResponseEntity containing the error details and a NOT_FOUND status
     */
    @ExceptionHandler(ProfileNotFoundException.class)
    public ResponseEntity<Object> handleProfileNotFoundException(ProfileNotFoundException ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "Profile Not Found");
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles SellerSKUNotFoundException by returning a 404 response with a custom error message.*/
    @ExceptionHandler(SellerSKUNotFoundException.class)
    public ResponseEntity<Object> handleSellerSKUNotFoundException(SellerSKUNotFoundException ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "Seller SKU Not Found");
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles any other exceptions not explicitly handled by other methods.
     * Returns a 500 response with a general error message.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "Internal Server Error");
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}