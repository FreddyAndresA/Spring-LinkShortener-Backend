package LinkShortener.dto;

import LinkShortener.exception.ErrorType;
import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private HttpStatus status;
    private String message;
    private ErrorType errorType;

    public ErrorResponse(HttpStatus status, String message, ErrorType errorType) {
        this.status = status;
        this.message = message;
        this.errorType = errorType;
    }

    public int getStatus() {
        return status.value();
    }

    public String getMessage() {
        return message;
    }

    public ErrorType getErrorType() {
        return errorType;
    }
}
