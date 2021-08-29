package ru.atom.hachaton.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.atom.hachaton.model.dto.out.LegalOrganizationDto;
import ru.atom.hachaton.service.local.LegalOrganizationService;

@RestController
@RequestMapping("/org/legal")
public class LegalOrganizationController {

    private final LegalOrganizationService service;

    public LegalOrganizationController(LegalOrganizationService service) {
        this.service = service;
    }

    @GetMapping("/{inn}")
    public ResponseEntity<LegalOrganizationDto> findByInn(@PathVariable("inn") String inn){
        return ResponseEntity.ok(service.findByInn(inn));
    }
}
