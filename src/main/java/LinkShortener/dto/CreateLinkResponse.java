package LinkShortener.dto;

public class CreateLinkResponse {

    private String shortCode;

    public CreateLinkResponse(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getShortCode() {
        return shortCode;
    }
}
