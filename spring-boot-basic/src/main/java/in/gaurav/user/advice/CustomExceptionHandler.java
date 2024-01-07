package in.gaurav.user.advice;

import in.gaurav.user.exception.ErrorDetails;
import in.gaurav.user.exception.PostNotFoundException;
import in.gaurav.user.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGenericException(Exception exception, WebRequest webRequest) {
        return ResponseEntity.internalServerError()
                .body(new ErrorDetails(
                        exception.getMessage(),
                        webRequest.getDescription(true))
                );
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException exception, WebRequest webRequest) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDetails(
                        exception.getMessage(),
                        webRequest.getDescription(true))
                );
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlePostNotFoundException(PostNotFoundException exception, WebRequest webRequest) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDetails(
                        exception.getMessage(),
                        webRequest.getDescription(true))
                );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity.badRequest()
                .body(new ErrorDetails(
                        "Total Errors: %d and errors are: %s".formatted(
                                ex.getErrorCount(),
                                ex.getFieldErrors().stream()
                                        .map(FieldError::getDefaultMessage)
                                        .collect(Collectors.joining(", "))
                        ),
                        request.getDescription(true))
                );
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(
            HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(new ErrorDetails(
                        Objects.requireNonNullElse(ex.getBody().getDetail(), "HTTP media type not acceptable"),
                        request.getDescription(true))
                );
    }

}
