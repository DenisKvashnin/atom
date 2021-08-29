package ru.atom.hachaton.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.atom.hachaton.model.entity.Okved2OuterOrgType;

import java.util.List;

public interface Okved2OuterTypeRepository extends CrudRepository<Okved2OuterOrgType, Long> {
    List<Okved2OuterOrgType> findAll();

    @Query("SELECT okved_code FROM okved_2_outer_type WHERE org_type_id IN (:types)")
    List<String> findOkvedCodes(@Param("types") List<Long> types);
}
