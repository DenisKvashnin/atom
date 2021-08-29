package ru.atom.hachaton.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.atom.hachaton.model.entity.Region;
import ru.atom.hachaton.service.local.MapService;
import ru.atom.hachaton.service.local.RegionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/region")
public class RegionController {

    private final RegionService regionService;
    private final MapService mapService;

    public RegionController(RegionService regionService,
                            MapService mapService) {
        this.regionService = regionService;
        this.mapService = mapService;
    }

    @GetMapping
    public ResponseEntity<List<Region>> findAll() {
        return ResponseEntity.ok(
                regionService.findAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> findById(@PathVariable Long id) {
        Optional<Region> regionOptional = regionService.findById(id);
        return regionOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }
}
