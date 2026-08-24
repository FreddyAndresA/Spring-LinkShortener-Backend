package LinkShortener.exception;

import LinkShortener.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleLinkNotFound(LinkNotFoundException exception) {
        String message = "Link with short code '" + exception.getShortCode() + "' was not found";
        ErrorResponse errorResponse = new ErrorResponse(404, message, ErrorType.LINK_NOT_FOUND);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(
            MethodArgumentNotValidException exception) {

        var errors = exception.getBindingResult().getFieldErrors();
        var error = errors.get(0);
        String message = error.getField() + ": " + error.getDefaultMessage();

        ErrorResponse errorResponse = new ErrorResponse(400, message, ErrorType.VALIDATION_ERROR);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);

    }

}
