package ru.atom.hachaton.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.atom.hachaton.model.dto.OrgCountTypeDto;
import ru.atom.hachaton.model.dto.out.OrgAddressDto;
import ru.atom.hachaton.model.entity.Organization;

import java.util.List;

public interface OrganizationRepository extends CrudRepository<Organization, Long> {


    @Query("SELECT org.id,\n" +
            "org.name,\n" +
            "org.okved,\n" +
            "org.okved_name,\n" +
            "org.inn,\n" +
            "org.address,\n" +
            "org.i_index,\n" +
            "org.site,\n" +
            "org.city,\n" +
            "org.timezone,\n" +
            "org.status,\n" +
            "l.lat,\n" +
            "l.lon\n" +
            " FROM organization org " +
            " LEFT JOIN org_location l ON l.org_id = org.id " +
            "WHERE :org_name = 'stubCache' OR UPPER(name) LIKE '%' || UPPER(:org_name) || '%'")
    List<Organization> findAll(@Param("org_name") String orgName);

    @Query("SELECT r.name_ru, org.okved_name edu_type, COUNT(*) count_org\n" +
            "                  FROM region r\n" +
            "                 JOIN organization org ON UPPER(replace(address, ' ', '')) LIKE '%' || UPPER(replace(r.name_ru, ' ', '')) || '%'\n" +
            "                 GROUP BY r.name_ru, org.okved_name")
    List<OrgCountTypeDto> findEduOrganization();

    @Query("SELECT id, address FROM organization org")
    List<OrgAddressDto> address();

    @Query("SELECT org.id,\n" +
            "org.name,\n" +
            "org.okved,\n" +
            "org.okved_name,\n" +
            "org.inn,\n" +
            "org.address,\n" +
            "org.i_index,\n" +
            "org.site,\n" +
            "org.city,\n" +
            "org.timezone,\n" +
            "org.status,\n" +
            "l.lat,\n" +
            "l.lon\n" +
            "FROM organization org\n" +
            " LEFT JOIN org_location l ON l.org_id = org.id " +
            "WHERE \n" +
            " (:org_name IS NULL OR UPPER(name) LIKE '%' || UPPER(:org_name) || '%') AND " +
            "(:region IS NULL OR UPPER(replace(address, ' ', '')) LIKE '%' || UPPER(replace(:region, ' ', '')) || '%') " +
            "ORDER BY org.id")
    List<Organization> find(
            @Param("org_name") String name,
            @Param("region") String region);
}
