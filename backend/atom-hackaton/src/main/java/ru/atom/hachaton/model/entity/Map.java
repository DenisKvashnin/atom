package ru.atom.hachaton.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("map_info")
public class Map {
    @Id
    private Long id;
    private String region;
    private String municipality;
    private String settlement;
    @Column("t_type")
    private String type;
    private String population;
    private String children;
    @Column("latitudeDms")
    private String latitudeDms;
    @Column("longitudeDms")
    private String longitudeDms;
    @Column("latitudeDd")
    private String latitudeDd;
    @Column("longitudeDd")
    private String longitudeDd;
    private String oktmo;
    private String dadata;
}