package ru.atom.hachaton.model.dto.out;

import lombok.Data;

import java.util.Map;

@Data
public class OrgTypeCountDto {
    Map<String, Integer> types;
}
