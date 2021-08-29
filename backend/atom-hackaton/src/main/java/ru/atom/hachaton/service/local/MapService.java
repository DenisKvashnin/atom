package ru.atom.hachaton.service.local;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.atom.hachaton.model.dto.MapSearchDto;
import ru.atom.hachaton.model.entity.Map;
import ru.atom.hachaton.repository.MapRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapService {

    private final MapRepository mapRepository;

    public MapService(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    @Cacheable("mapSearchData")
    public List<Map> find(String city, String regionName) {
        return mapRepository.find(city, regionName);
    }

    public List<MapSearchDto> searchData(String searchString) {
        return mapRepository.searchData(searchString);
    }

    public List<String> findCityRegion(List<String> regions) {
        List<String> results = new ArrayList<>();
        for (String region : regions) {
            results.addAll(mapRepository.findCityByRegion(region));
        }
        return results;
    }

    public List<String> findRegionByCity(List<String> cities) {
        List<String> results = new ArrayList<>();
        for (String city : cities) {
            results.addAll(mapRepository.findRegionByCity(city));
        }
        return results;
    }
}
