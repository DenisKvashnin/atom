package ru.atom.hachaton.model.data.out;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class SocialNetworksDto {

    private Set<String> instagram = new HashSet<>();
    private Set<String> vk = new HashSet<>();
    private Set<String> facebook = new HashSet<>();
    private Set<String> ok = new HashSet<>();
    private Set<String> youtube = new HashSet<>();

    public void addInstagramUrl(String url){
        instagram.add(url);
    }

    public void addVkUrl(String url){
        vk.add(url);
    }

    public void addFacebookUrl(String url){
        facebook.add(url);
    }

    public void addOkUrl(String url){
        ok.add(url);
    }

    public void addYoutubeUrl(String url){
        youtube.add(url);
    }
}

