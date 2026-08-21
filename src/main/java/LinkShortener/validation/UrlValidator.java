package LinkShortener.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.net.URI;

public class UrlValidator implements ConstraintValidator<ValidUrl, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        try {
            URI uri = URI.create(value);

            if (!"http".equalsIgnoreCase(uri.getScheme())
                    && !"https".equalsIgnoreCase(uri.getScheme())) {
                return false;
            }

            if (uri.getHost() == null) {
                return false;
            }

            return true;

        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
}