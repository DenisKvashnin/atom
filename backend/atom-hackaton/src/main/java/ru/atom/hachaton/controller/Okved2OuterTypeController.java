package ru.atom.hachaton.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.atom.hachaton.model.entity.Okved2OuterOrgType;
import ru.atom.hachaton.service.local.Okved2OuterTypeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/okved2outer/type")
public class Okved2OuterTypeController {

    private final Okved2OuterTypeService service;

    public Okved2OuterTypeController(Okved2OuterTypeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Okved2OuterOrgType>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Okved2OuterOrgType> findById(@PathVariable Long id){
        Optional<Okved2OuterOrgType> okved2OuterOrgType = service.findById(id);
        return okved2OuterOrgType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }
}
