package ru.atom.hachaton.model.dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.atom.hachaton.model.entity.Organization;
import ru.atom.hachaton.model.entity.Region;

@Data
@AllArgsConstructor
public class OrganizationDto {
    private Organization organization;
    private Region region;
    private String population;
    private Integer raexPosition;
    private String qs;
}
