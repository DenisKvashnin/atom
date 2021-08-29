package ru.atom.hachaton.service.processing;

import liquibase.pro.packaged.O;
import org.springframework.stereotype.Service;
import ru.atom.hachaton.model.dto.OrgCountTypeDto;
import ru.atom.hachaton.model.dto.out.OrgTypeCountDto;
import ru.atom.hachaton.model.dto.out.OrgTypeCountListDto;
import ru.atom.hachaton.repository.OrganizationRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrganizationProcessingService {

    private final OrganizationRepository organizationRepository;

    public OrganizationProcessingService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public OrgTypeCountListDto findEduOrganization() {
        List<OrgCountTypeDto> orgCountTypeDtos = organizationRepository.findEduOrganization();

        OrgTypeCountListDto orgTypeCountListDto = new OrgTypeCountListDto();

        Map<String, OrgTypeCountDto> regionStatistics = new HashMap<>();

        orgTypeCountListDto.setRegionStatistics(regionStatistics);

        for (OrgCountTypeDto org : orgCountTypeDtos) {

            Map<String, OrgTypeCountDto> statistics = orgTypeCountListDto.getRegionStatistics();

            if (statistics != null &&
                    statistics.containsKey(org.getNameRu())) {
                Map<String, Integer> map = statistics.get(org.getNameRu()).getTypes();

                if(map.containsKey(org.getEduType())){
                    continue;
                }

                map.put(org.getEduType(), org.getCountOrg());

            }else {

                OrgTypeCountDto orgTypeCountDto = new OrgTypeCountDto();

                Map<String, Integer> types = new HashMap<>();

                types.put(org.getEduType(), org.getCountOrg());

                orgTypeCountDto.setTypes(types);

                regionStatistics.put(org.getNameRu(), orgTypeCountDto);
            }
        }

        return orgTypeCountListDto;
    }
}
