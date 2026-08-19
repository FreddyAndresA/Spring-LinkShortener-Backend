package LinkShortener.service;

import LinkShortener.dto.CreateLinkRequest;
import LinkShortener.entity.Link;
import LinkShortener.exception.LinkNotFoundException;
import LinkShortener.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class LinkService {

    private LinkRepository linkRepository;


    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }


    public Link getLink(String shortCode) {
        return linkRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new LinkNotFoundException());
    }


    public Link saveLink(CreateLinkRequest createLinkRequest) {

        String shortCode = generateShortCode();
        while (linkRepository.existsByShortCode(shortCode)) {
            shortCode = generateShortCode();
        }

        String originalUrl = createLinkRequest.getOriginalUrl();
        Link link = new Link();
        link.setOriginalUrl(originalUrl);
        link.setShortCode(shortCode);
        return linkRepository.save(link);
    }


    private String generateShortCode(){
        final String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        String shortCode = "";

        for (int i = 0; i < 6; i++) {
            int number = random.nextInt(characters.length());
            shortCode += characters.charAt(number);
        }

        return shortCode;
    }

}
