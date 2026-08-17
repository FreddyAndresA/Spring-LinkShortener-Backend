package LinkShortener.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Link {

    @Id
    @GeneratedValue()
    private Long id;
    private String originalUrl;
    @Column(length = 6, unique = true)
    private String shortCode;
}
