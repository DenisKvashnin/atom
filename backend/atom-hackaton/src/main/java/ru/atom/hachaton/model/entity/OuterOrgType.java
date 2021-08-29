package ru.atom.hachaton.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("outer_org_type")
public class OuterOrgType {
    @Id
    private Long id;
    private String description;
}
