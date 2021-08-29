package ru.atom.hachaton.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.atom.hachaton.model.data.out.SocialNetworksDto;
import ru.atom.hachaton.service.processing.LinkExtractorService;

import javax.validation.constraints.NotNull;
import java.io.IOException;

@RestController
@RequestMapping("/linkextractor")
public class LinkExtractorController {

    private final LinkExtractorService service;

    public LinkExtractorController(LinkExtractorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SocialNetworksDto> extract(@NotNull @RequestBody String url)
            throws IOException {
        SocialNetworksDto socialNetworks = service.extractLink(url);
        return ResponseEntity.ok(socialNetworks);
    }

}
