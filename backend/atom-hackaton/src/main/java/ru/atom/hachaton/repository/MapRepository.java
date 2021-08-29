package ru.atom.hachaton.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.atom.hachaton.model.dto.MapSearchDto;
import ru.atom.hachaton.model.entity.Map;


import java.util.List;

public interface MapRepository extends CrudRepository<Map, Long> {

    @Query("SELECT * FROM map_info WHERE (:city IS NULL OR UPPER(settlement) = UPPER(:city)) " +
            "AND (:region_name IS NULL OR UPPER(region) = UPPER(:region_name))")
    List<Map> find(@Param("city") String city,
                   @Param("region_name") String regionName);

    @Query("SELECT src.id, src.full_name, src.population" +
            " FROM \n" +
            " (SELECT m.id, CONCAT(m.region, ', ', m.t_type, '. ', m.settlement, ', ', m.municipality) full_name, m.population \n" +
            "  FROM map_info m) src " +
            "WHERE UPPER(src.full_name) LIKE '%' || UPPER(LEFT(:search_string, 4)) || '%'")
    List<MapSearchDto> searchData(
            @Param("search_string") String searchString
    );

    @Query("SELECT DISTINCT src.settlement FROM (SELECT settlement FROM map_info " +
            " WHERE UPPER(region) LIKE '%'|| UPPER(:region) || '%'" +
            " ORDER BY CAST(population AS INTEGER) DESC) src")
    List<String> findCityByRegion(@Param("region")  String region);

    @Query("SELECT DISTINCT src.region FROM (SELECT region FROM map_info " +
            "WHERE UPPER(settlement) LIKE '%' || UPPER(:city) || '%'" +
            " ORDER BY CAST(population AS INTEGER) DESC) src")
    List<String> findRegionByCity(@Param("city") String city);
}
