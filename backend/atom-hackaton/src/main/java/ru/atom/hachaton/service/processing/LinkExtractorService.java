package ru.atom.hachaton.service.processing;

import com.linkedin.urls.Url;
import com.linkedin.urls.detection.UrlDetector;
import com.linkedin.urls.detection.UrlDetectorOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.atom.hachaton.model.data.out.SocialNetworksDto;
import ru.atom.hachaton.model.enums.SocialNetwork;

import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

@Service
@Slf4j
public class LinkExtractorService {

    @Cacheable(value = "socialNetwork")
    public SocialNetworksDto extractLink(@NotNull String url) throws IOException {
        String content = this.downloadPage(url);
        return this.getLinksOnPage(content);
    }

    private SocialNetworksDto getLinksOnPage(@NotNull String content) {
        UrlDetector urlDetector = new UrlDetector(content, UrlDetectorOptions.HTML);

        List<Url> urls = urlDetector.detect();

        if (urls.isEmpty()) {
            return new SocialNetworksDto();
        }

        SocialNetworksDto socialNetworksDto = new SocialNetworksDto();

        for (Url url : urls) {
            String host = url.getHost();
            if (host.contains(SocialNetwork.VK.label)) {
                socialNetworksDto.addVkUrl(url.getFullUrl());
            } else if (host.contains(SocialNetwork.INSTAGRAM.label)) {
                socialNetworksDto.addInstagramUrl(url.getFullUrl());
            } else if (host.contains(SocialNetwork.FACEBOOK.label)) {
                socialNetworksDto.addFacebookUrl(url.getFullUrl());
            }else if(host.contains(SocialNetwork.YOUTUBE.label)){
                socialNetworksDto.addYoutubeUrl(url.getFullUrl());
            }else if(host.contains(SocialNetwork.OK.label)){
                socialNetworksDto.addOkUrl(url.getFullUrl());
            }
        }

        return socialNetworksDto;
    }


    private String downloadPage(@NotNull String address) throws IOException {
        String line;
        StringBuilder resultContent = new StringBuilder();

        URL url = new URL(address);
        try (InputStream is = url.openStream()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                while ((line = br.readLine()) != null) {
                    resultContent.append(line);
                }
            }
        }

        return resultContent.toString();
    }
}
