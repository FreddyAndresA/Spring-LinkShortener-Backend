package LinkShortener.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue()
    private Long id;
    @Column(nullable = false)
    private String originalUrl;
    @Column(length = 6, unique = true, nullable = false)
    private String shortCode;
}
