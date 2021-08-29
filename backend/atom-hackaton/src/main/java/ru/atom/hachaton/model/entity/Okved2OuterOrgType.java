package ru.atom.hachaton.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("okved_2_outer_type")
public class Okved2OuterOrgType {
    @Id
    private Long id;
    private String okvedCode;
    private Long orgTypeId;
}
