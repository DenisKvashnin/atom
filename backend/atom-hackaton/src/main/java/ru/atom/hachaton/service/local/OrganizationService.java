package ru.atom.hachaton.service.local;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.atom.hachaton.model.dto.out.OrgAddressDto;
import ru.atom.hachaton.model.dto.out.OrganizationContainerDto;
import ru.atom.hachaton.model.dto.out.OrganizationDto;
import ru.atom.hachaton.model.entity.Map;
import ru.atom.hachaton.model.entity.Organization;
import ru.atom.hachaton.model.entity.Region;
import ru.atom.hachaton.repository.OrganizationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrganizationService {

    private final OrganizationRepository repository;
    private final MapService mapService;
    private final Okved2OuterTypeService okved2OuterTypeService;
    private final RegionService regionService;
    private final RaexDictionaryService raexDictionaryService;
    private final AtomCityDictionaryService atomCityDictionaryService;


    public OrganizationService(OrganizationRepository repository,
                               MapService mapService,
                               Okved2OuterTypeService okved2OuterTypeService,
                               RegionService regionService,
                               RaexDictionaryService raexDictionaryService,
                               AtomCityDictionaryService atomCityDictionaryService) {
        this.repository = repository;
        this.mapService = mapService;
        this.okved2OuterTypeService = okved2OuterTypeService;
        this.regionService = regionService;
        this.raexDictionaryService = raexDictionaryService;
        this.atomCityDictionaryService = atomCityDictionaryService;
    }

    public Optional<Organization> findById(Long id) {
        return repository.findById(id);
    }

    public List<OrgAddressDto> address() {
        return repository.address();
    }

    public OrganizationContainerDto find(String orgName,
                                         List<String> regions,
                                         List<String> cities,
                                         Integer numberOfPeople,
                                         List<Long> types,
                                         Boolean isAtomCity,
                                         Boolean isRaexOrg,
                                         Integer countRow,
                                         Integer skip) {

        List<Organization> regionOrganizations = new ArrayList<>();

        if (regions == null || regions.isEmpty()) {
            regionOrganizations = this.findAllByName(orgName == null ?
                            "stubCache" :
                            orgName,
                    isAtomCity,
                    isRaexOrg
            );
        } else {
            try {
                for (String region : regions) {
                    regionOrganizations.addAll(
                            this.findAll(
                                    orgName,
                                    region,
                                    isAtomCity,
                                    isRaexOrg
                            )
                    );
                }
            } catch (Exception e) {
                log.error(e.getMessage());
                regionOrganizations = repository.findAll(orgName);
            }
        }

        List<Organization> filteredByCity = regionOrganizations;
        if (cities != null && !cities.isEmpty()) {
            filteredByCity = regionOrganizations
                    .parallelStream()
                    .distinct()
                    .filter(
                            f -> cities.contains(f.getCity()
                            )
                    )
                    .collect(Collectors.toList());
        }

        if (types != null && !types.isEmpty()) {
            List<String> okved2OuterOrgTypes = okved2OuterTypeService.find(types);
            filteredByCity =
                    filteredByCity
                            .stream()
                            .filter(
                                    f -> okved2OuterOrgTypes.contains(f.getOkved())
                            )
                            .collect(Collectors.toList());
        }

        List<Region> regionList = regionService.findAll();
        List<OrganizationDto> organizationDtos = new ArrayList<>();
        if (!regionList.isEmpty()) {
            for (Organization org : filteredByCity) {
                try {
                    Optional<Region> foundRegion =
                            regionList
                                    .stream()
                                    .filter(f ->
                                            org.getAddress().toUpperCase().contains(f.getNameRu().toUpperCase())
                                    ).findFirst();
                    organizationDtos.add(new OrganizationDto(org, foundRegion.orElse(null), null, null, null));
                } catch (Exception ex) {
                    log.error(ex.getMessage());
                }
            }
        } else {
            for (Organization organization : filteredByCity) {
                organizationDtos.add(new OrganizationDto(organization, null, null, null, null));
            }
        }

        if (isRaexOrg) {
            Set<String> r = raexDictionaryService.getRaexFullSet();
            List<OrganizationDto> forDelete = new ArrayList<>();
            for (OrganizationDto org : organizationDtos) {
                if (!r.contains(org.getOrganization().getInn())) {
                    forDelete.add(org);
                }
            }

            for (OrganizationDto org : forDelete) {
                organizationDtos.remove(org);
            }
        }

        if (isAtomCity) {
            Set<String> atomCity = atomCityDictionaryService.getSetsCityName();
            organizationDtos = organizationDtos
                    .stream()
                    .filter(f ->
                            atomCity.contains(f.getOrganization().getCity().toUpperCase())
                    )
                    .collect(Collectors.toList());
        }

        for (OrganizationDto org : organizationDtos) {
            if (org.getRegion() == null) continue;
            List<Map> maps = mapService.find(org.getOrganization().getCity(), org.getRegion().getNameRu());
            if (!maps.isEmpty()) {
                String population = maps.get(0).getPopulation();
                org.setPopulation(population);
            }
        }

        if (numberOfPeople != null) {
            organizationDtos =
                    organizationDtos
                            .stream()
                            .filter(f ->
                                    populationFilter(f, numberOfPeople)
                            )
                            .collect(Collectors.toList());
        }

        int totalRowCount = (int) Math.ceil(organizationDtos.size() / countRow);

        if (skip != null && countRow != null) {
            organizationDtos = organizationDtos
                    .stream()
                    .skip((long) (skip - 1) * countRow)
                    .limit(countRow)
                    .collect(Collectors.toList());
        }
        return new OrganizationContainerDto(organizationDtos, totalRowCount);
    }

    private boolean populationFilter(OrganizationDto organizationDto, int numberOfPeople) {
        if (organizationDto.getPopulation() == null) {
            return false;
        }

        int population = 0;

        try {
            population = Integer.parseInt(organizationDto.getPopulation());
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        if (numberOfPeople == 1 && population < 100_000) {
            return true;
        } else if (numberOfPeople == 2) {
            return population >= 100_000 && population < 500_000;
        } else if (numberOfPeople == 3) {
            return population >= 500_000 && population < 1_000_000;
        } else if (numberOfPeople == 4) {
            return population >= 1_000_000;
        }
        return false;
    }

    @Cacheable("findAllRegion")
    public List<Organization> findAll(String orgName,
                                      String region,
                                      boolean isAtomCity,
                                      boolean isRaexOrg) {
        return repository.find(
                orgName,
                region
        );
    }

    @Cacheable("findAllByName")
    public List<Organization> findAllByName(String orgName,
                                            boolean isAtomCity,
                                            boolean isRaexOrg) {
        return repository.findAll(orgName);
    }
}
