package Tivoli.Onboarding.Exception;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandling {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandling.class);

    // Error Response Builder
    private ResponseEntity<ErrorMessage> errorResponseBuilder(HttpStatus status,
                                                              String message,
                                                              HttpServletRequest request) {
        ErrorMessage errorResponse = new ErrorMessage(
                LocalDateTime.now(),
                message,
                request.getRequestURI()

        );

        logger.error("Error: {} | Status: {} | Path: {}", message, status.value(), request.getRequestURI());
        return ResponseEntity.status(status).body(errorResponse);
    }

    // Exception Handler for duplicates
    @ExceptionHandler(DuplicateResourceFoundException.class)
    public ResponseEntity<ErrorMessage> handlerDuplicateResourceFoundException(DuplicateResourceFoundException e,
                                                                               HttpServletRequest request) {
        return errorResponseBuilder(HttpStatus.CONFLICT, e.getMessage(), request);
    }

    // Exception handler for not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlerResourceNotFoundException(ResourceNotFoundException e,
                                                                         HttpServletRequest request) {
        return errorResponseBuilder(HttpStatus.NOT_FOUND, e.getMessage(), request);
    }

    @ExceptionHandler(InvalidFileException.class)
    public ResponseEntity<ErrorMessage> handlerInvalidFileException(InvalidFileException e,
                                                                    HttpServletRequest request) {
        return errorResponseBuilder(HttpStatus.BAD_REQUEST, e.getMessage(), request);
    }


}
