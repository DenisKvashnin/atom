package ru.atom.hachaton.model.data.out.dadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Opf {
    private String type;
    private String code;
    private String full;
    @JsonProperty("short")
    private String shortName;
}
