package LinkShortener.controller;

import LinkShortener.dto.CreateLinkRequest;
import LinkShortener.entity.Link;
import LinkShortener.service.LinkService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkController {

    private LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/links")
    public Link createLink(@Valid @RequestBody CreateLinkRequest createLinkRequest) {
        return linkService.saveLink(createLinkRequest);
    }

}
