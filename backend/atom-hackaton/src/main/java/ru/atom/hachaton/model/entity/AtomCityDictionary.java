package ru.atom.hachaton.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("atom_city_dict")
public class AtomCityDictionary {
    @Id
    private Long id;
    private String city;
    private String regionCode;
}
