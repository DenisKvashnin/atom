package ru.atom.hachaton.service.processing;

import me.xdrop.fuzzywuzzy.FuzzySearch;
import org.springframework.stereotype.Service;
import ru.atom.hachaton.model.dto.MapSearchDto;
import ru.atom.hachaton.service.local.MapService;

import javax.validation.constraints.NotNull;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final MapService mapService;

    public SearchService(MapService mapService) {
        this.mapService = mapService;
    }

    public List<MapSearchDto> find(@NotNull String searchString) {
        String upperSearchString = searchString.toUpperCase();

        List<MapSearchDto> searchData = mapService.searchData(searchString);

        List<MapSearchDto> searchDtos = searchData
                .stream()
                .sorted(
                        Comparator.comparing(
                                        (MapSearchDto o)
                                                -> FuzzySearch.partialRatio(
                                                upperSearchString,
                                                o.getFullName().toUpperCase()
                                        )
                                )
                                .reversed()
                )
                .limit(5)
                .collect(Collectors.toList());

        return searchDtos.stream().sorted(
                        Comparator.comparing(
                                        (MapSearchDto o) ->
                                                Integer.parseInt(o.getPopulation())
                                )
                                .reversed()
                )
                .collect(Collectors.toList());
    }
}
