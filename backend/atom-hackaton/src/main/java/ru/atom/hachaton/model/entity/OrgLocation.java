package ru.atom.hachaton.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("org_location")
public class OrgLocation {
    @Id
    private Long id;
    private Long orgId;
    private Double lat;
    private Double lon;
}
