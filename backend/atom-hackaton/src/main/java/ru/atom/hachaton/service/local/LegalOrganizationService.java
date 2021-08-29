package ru.atom.hachaton.service.local;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.atom.hachaton.model.dto.out.LegalOrganizationDto;
import ru.atom.hachaton.model.dto.out.OrganizationDto;
import ru.atom.hachaton.model.dto.out.Program;
import ru.atom.hachaton.model.entity.LegalOrganization;
import ru.atom.hachaton.repository.LegalOrganizationRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@Service
public class LegalOrganizationService {

    private final LegalOrganizationRepository repository;
    private final RaexDictionaryService raexDictionaryService;

    public LegalOrganizationService(LegalOrganizationRepository repository,
                                    RaexDictionaryService raexDictionaryService) {
        this.repository = repository;
        this.raexDictionaryService = raexDictionaryService;
    }

    public LegalOrganizationDto findByInn(@NotNull String inn) {

        List<LegalOrganization> legalOrganizations = repository.findByInn(inn);

        if (legalOrganizations == null || legalOrganizations.isEmpty()) {
            return null;
        }

        LegalOrganization legalOrganization = legalOrganizations.get(0);


        String licenseSysGuid = legalOrganization.getLicenseSysGuid();

        List<LegalOrganization> actualOrganizations = repository.finBySupplementLicenseFk(licenseSysGuid);
        if (actualOrganizations.isEmpty()) {
            return null;
        }

        LegalOrganization actualOrganization = actualOrganizations.get(0);

        List<Program> programs = repository.findProgramm(actualOrganization.getSupplementSysGuid());

        LegalOrganizationDto legalOrganizationDto = new LegalOrganizationDto();
        legalOrganizationDto.setLegalOrganization(legalOrganization);

        legalOrganizationDto.setPrograms(programs);

        var raexDictionary = raexDictionaryService.raex(inn);
        if (raexDictionary == null) {
            legalOrganizationDto.setRaex(0);
            legalOrganizationDto.setQs("0");
        } else {
            legalOrganizationDto.setRaex(raexDictionary.getPosition());
            legalOrganizationDto.setQs(raexDictionary.getQs());
        }


        return legalOrganizationDto;
    }
}
