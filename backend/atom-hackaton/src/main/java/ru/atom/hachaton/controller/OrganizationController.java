package ru.atom.hachaton.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.atom.hachaton.model.dto.out.OrgAddressDto;
import ru.atom.hachaton.model.dto.out.OrgTypeCountListDto;
import ru.atom.hachaton.model.dto.out.OrganizationContainerDto;
import ru.atom.hachaton.model.entity.Organization;
import ru.atom.hachaton.service.local.OrganizationService;
import ru.atom.hachaton.service.processing.OrganizationProcessingService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/org")
public class OrganizationController {

    private final OrganizationService organizationService;
    private final OrganizationProcessingService organizationProcessingService;

    public OrganizationController(OrganizationService organizationService,
                                  OrganizationProcessingService organizationProcessingService) {
        this.organizationService = organizationService;
        this.organizationProcessingService = organizationProcessingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organization> findById(@PathVariable Long id) {
        Optional<Organization> organizationOptional = organizationService.findById(id);
        return organizationOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/statistics")
    public ResponseEntity<OrgTypeCountListDto> statOrganization() {
        OrgTypeCountListDto orgTypeCountListDto = organizationProcessingService.findEduOrganization();
        return ResponseEntity.ok(orgTypeCountListDto);
    }

    @GetMapping("/address")
    public ResponseEntity<List<OrgAddressDto>> address() {
        return ResponseEntity.ok(organizationService.address());
    }

    @GetMapping("/find")
    public ResponseEntity<OrganizationContainerDto> find(
            @RequestParam(required = false) String orgName,
            @RequestParam(required = false) List<String> regions,
            @RequestParam(required = false) List<String> cities,
            @RequestParam(required = false) Integer numberOfPeople,
            @RequestParam(required = false) List<Long> types,
            @RequestParam(required = false) boolean isAtomCity,
            @RequestParam(required = false) boolean isRaexOrg,
            @RequestParam(required = false) Integer countRow,
            @RequestParam(required = false) Integer skip) {
        return ResponseEntity.ok(
                organizationService.find(
                        orgName,
                        regions,
                        cities,
                        numberOfPeople,
                        types,
                        isAtomCity,
                        isRaexOrg,
                        countRow,
                        skip
                )
        );
    }

}
