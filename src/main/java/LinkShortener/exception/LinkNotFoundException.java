package LinkShortener.exception;

public class LinkNotFoundException extends RuntimeException {

    private String shortCode;

    public LinkNotFoundException(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getShortCode() {
        return shortCode;
    }
}
