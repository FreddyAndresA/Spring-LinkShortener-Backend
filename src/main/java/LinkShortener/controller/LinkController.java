package LinkShortener.controller;

import LinkShortener.dto.CreateLinkRequest;
import LinkShortener.entity.Link;
import LinkShortener.service.LinkService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    private LinkService linkService;


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


    @PostMapping("/links")
    public Link createLink(@Valid @RequestBody CreateLinkRequest createLinkRequest) {
        return linkService.saveLink(createLinkRequest);
    }

}
