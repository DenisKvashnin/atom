package ru.atom.hachaton.model.dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.atom.hachaton.model.entity.LegalOrganization;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LegalOrganizationDto {
    private LegalOrganization legalOrganization;
    private List<Program> programs;
    private Integer raex;
    private String qs;
}
