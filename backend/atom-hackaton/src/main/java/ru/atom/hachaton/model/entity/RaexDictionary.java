package ru.atom.hachaton.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("raex_dict")
public class RaexDictionary {
    @Id
    private Long id;
    private Integer position;
    private String fullName;
    private String inn;
    private String qs;
}
