package ru.atom.hachaton.model.enums;

public enum SocialNetwork {
    FACEBOOK("facebook.com"),
    INSTAGRAM("instagram.com"),
    VK("vk.com"),
    OK("ok.ru"),
    YOUTUBE("youtube.com");

    public final String label;

    private SocialNetwork(String label){
        this.label = label;
    }
}
