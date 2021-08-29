package ru.atom.hachaton.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.atom.hachaton.model.entity.OuterOrgType;
import ru.atom.hachaton.service.local.OuterOrgTypeService;

import java.util.List;

@RestController
@RequestMapping("/outer/org/type")
public class OuterOrgTypeController {

    private final OuterOrgTypeService service;

    public OuterOrgTypeController(OuterOrgTypeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<OuterOrgType>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
