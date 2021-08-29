package ru.atom.hachaton.model.dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationContainerDto {
    public List<OrganizationDto> organizationDto;
    private Integer totalCountRows;
}
