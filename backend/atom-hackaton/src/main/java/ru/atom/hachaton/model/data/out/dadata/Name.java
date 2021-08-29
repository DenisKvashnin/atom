package ru.atom.hachaton.model.data.out.dadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Name {
    private String fullWithOpf;
    private String shortWithOpf;
    private String latin;
    private String full;
    @JsonProperty("short")
    private String shortName;
}
