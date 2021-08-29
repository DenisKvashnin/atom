package ru.atom.hachaton.model.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("region")
public class Region {
    private Long id;
    private String nameRu;
    private String nameEng;
    private String pathImage;
}
