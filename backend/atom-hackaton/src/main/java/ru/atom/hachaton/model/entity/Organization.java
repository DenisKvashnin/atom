package ru.atom.hachaton.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("organization")
public class Organization {
    @Id
    private Long id;
    private String name;
    private String okved;
    private String okvedName;
    private String inn;
    private String address;
    @Column("i_index")
    private String index;
    private String site;
    private String city;
    private String timezone;
    private String status;
    private String lat;
    private String lon;
}
