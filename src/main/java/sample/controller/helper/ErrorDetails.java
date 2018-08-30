package sample.controller.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import sample.exception.ResourceNotFoundException;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    public Date getTimestamp() {
        return timestamp;
    }

    public ErrorDetails withTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ErrorDetails withMessage(String message) {
        this.message = message;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public ErrorDetails withDetails(String details) {
        this.details = details;
        return this;
    }


    @RestControllerAdvice
    public static class RestExceptionHandler {

        @ExceptionHandler(ResourceNotFoundException.class)
        public final ResponseEntity<ErrorDetails> handleUserNotFoundException(ResourceNotFoundException ex, WebRequest request) {
            ErrorDetails errorDetails = new ErrorDetails().withTimestamp(new Date()).withMessage(ex.getMessage())
                    .withDetails(request.getDescription(false));
            return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        }
    }
}