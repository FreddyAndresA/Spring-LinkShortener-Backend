package LinkShortener.dto;

import LinkShortener.exception.ErrorType;

public class ErrorResponse {

    private int status;
    private String message;
    private ErrorType errorType;

    public ErrorResponse(int status, String message, ErrorType errorType) {
        this.status = status;
        this.message = message;
        this.errorType = errorType;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ErrorType getErrorType() {
        return errorType;
    }
}
