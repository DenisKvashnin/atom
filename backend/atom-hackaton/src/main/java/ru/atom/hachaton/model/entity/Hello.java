package ru.atom.hachaton.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("hello")
@Data
public class Hello {
    @Id
    private Long id;
    private String name;
}
