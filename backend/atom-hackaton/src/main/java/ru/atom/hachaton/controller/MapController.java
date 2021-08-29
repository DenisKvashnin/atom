package ru.atom.hachaton.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.atom.hachaton.model.dto.MapSearchDto;
import ru.atom.hachaton.model.entity.Map;
import ru.atom.hachaton.service.local.MapService;
import ru.atom.hachaton.service.processing.SearchService;

import java.util.List;

@RestController
@RequestMapping("/map")
public class MapController {

    private final MapService mapService;
    private final SearchService searchService;

    public MapController(MapService mapService,
                         SearchService searchService) {
        this.mapService = mapService;
        this.searchService = searchService;
    }

    @GetMapping
    public ResponseEntity<List<Map>> find(@RequestParam(value = "city", required = false) String city,
                                          @RequestParam(value = "regionName", required = false) String regionName){

        List<Map> cities = mapService.find(city, regionName);
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/search")
    public ResponseEntity<List<MapSearchDto>> search(@RequestParam String searchString){
        return ResponseEntity.ok(searchService.find(searchString));
    }

    @GetMapping("/findCityByRegion")
    public ResponseEntity<List<String>> findCity(@RequestParam List<String> regions){
        return ResponseEntity.ok(mapService.findCityRegion(regions));
    }

    @GetMapping("/findRegionByCity")
    public ResponseEntity<List<String>> findRegion(@RequestParam List<String> cities){
        return ResponseEntity.ok(mapService.findRegionByCity(cities));
    }

}
