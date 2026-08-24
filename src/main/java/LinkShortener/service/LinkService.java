package LinkShortener.service;

import LinkShortener.dto.CreateLinkRequest;
import LinkShortener.dto.CreateLinkResponse;
import LinkShortener.entity.Link;
import LinkShortener.exception.LinkNotFoundException;
import LinkShortener.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class LinkService {

    private final SecureRandom random = new SecureRandom();
    private final LinkRepository linkRepository;


    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }


    public Link getLink(String shortCode) {
        return linkRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new LinkNotFoundException(shortCode));
    }


    public CreateLinkResponse saveLink(CreateLinkRequest createLinkRequest) {

        String shortCode = generateShortCode();
        while (linkRepository.existsByShortCode(shortCode)) {
            shortCode = generateShortCode();
        }

        String originalUrl = createLinkRequest.getOriginalUrl();
        Link link = new Link();
        link.setOriginalUrl(originalUrl);
        link.setShortCode(shortCode);
        linkRepository.save(link);

        return new CreateLinkResponse(shortCode);
    }


    public void deleteLink(String shortCode) {
        Link link = getLink(shortCode);
        linkRepository.delete(link);
    }


    private String generateShortCode(){
        final String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder shortCode = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int number = random.nextInt(characters.length());
            shortCode.append(characters.charAt(number));
        }

        return shortCode.toString();
    }

}
