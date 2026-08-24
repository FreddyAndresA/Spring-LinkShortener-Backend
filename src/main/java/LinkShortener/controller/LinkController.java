package LinkShortener.controller;

import LinkShortener.dto.CreateLinkRequest;
import LinkShortener.dto.CreateLinkResponse;
import LinkShortener.entity.Link;
import LinkShortener.service.LinkService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/links")
public class LinkController {

    private final LinkService linkService;


    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }


    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> getLink(@PathVariable("shortCode") String shortCode) {
        Link link = linkService.getLink(shortCode);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .header("Location", link.getOriginalUrl())
                .build();
    }


    @PostMapping
    public CreateLinkResponse createLink(@Valid @RequestBody CreateLinkRequest createLinkRequest) {
        return linkService.saveLink(createLinkRequest);
    }


    @DeleteMapping("/{shortCode}")
    public ResponseEntity<Void> deleteLink(@PathVariable("shortCode") String shortCode) {
        linkService.deleteLink(shortCode);

        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
