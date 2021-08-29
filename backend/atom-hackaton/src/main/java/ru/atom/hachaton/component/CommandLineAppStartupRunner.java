package ru.atom.hachaton.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.atom.hachaton.model.entity.Region;
import ru.atom.hachaton.service.local.AtomCityDictionaryService;
import ru.atom.hachaton.service.local.OrganizationService;
import ru.atom.hachaton.service.local.RegionService;

import java.util.List;

@Slf4j
@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final RegionService regionService;
    private final OrganizationService organizationService;
    private final AtomCityDictionaryService atomCityDictionaryService;

    public CommandLineAppStartupRunner(RegionService regionService,
                                       OrganizationService organizationService,
                                       AtomCityDictionaryService atomCityDictionaryService) {
        this.regionService = regionService;
        this.organizationService = organizationService;
        this.atomCityDictionaryService = atomCityDictionaryService;
    }

    @Override
    public void run(String... args) {
        List<Region> regions = regionService.findAll();
        for(Region region : regions){
            organizationService.findAll(null, region.getNameRu(), false, false);
        }

        organizationService.find(null, null, null, null, null, false, false, 10, 1);
        organizationService.find(null, null, null, null, null, true, false, 10, 1);
        organizationService.findAllByName("", false, false);
        organizationService.findAllByName("", true, false);
        organizationService.findAllByName("stubCache", false, false);
        organizationService.findAllByName("stubCache", true, false);
        organizationService.findAllByName("Москва", false, false);
        organizationService.findAllByName("Ростов", false, false);
        organizationService.findAllByName("Санкт-Петербург", false, false);
        organizationService.findAllByName("Новосибирск", false, false);
        organizationService.findAllByName("Екатеринбург", false, false);
        organizationService.findAllByName("Казань",false, false);
        organizationService.findAllByName("Рязань", false, false);
        organizationService.findAllByName("Ростов-на-Дону", false, false);

        atomCityDictionaryService.getSetsCityName();

        log.info("cache hoooooooot!");
    }
}
