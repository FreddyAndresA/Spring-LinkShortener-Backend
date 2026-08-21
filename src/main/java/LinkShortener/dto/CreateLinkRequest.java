package LinkShortener.dto;

import LinkShortener.validation.ValidUrl;
import jakarta.validation.constraints.NotBlank;

public class CreateLinkRequest {

    @NotBlank
    @ValidUrl
    private String originalUrl;

    public CreateLinkRequest() {
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
