package ru.atom.hachaton.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.atom.hachaton.model.entity.Okved;
import ru.atom.hachaton.service.local.OkvedService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/okved")
public class OkvedController {

    private final OkvedService okvedService;

    public OkvedController(OkvedService okvedService) {
        this.okvedService = okvedService;
    }

    @GetMapping
    public ResponseEntity<List<Okved>> findAll(){
        return ResponseEntity.ok(okvedService.findAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<Okved> findByCode(@PathVariable String code){
       Optional<Okved> okvedOptional =  okvedService.findByCode(code);
        return okvedOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }
}
