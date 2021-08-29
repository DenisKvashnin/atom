package ru.atom.hachaton.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.atom.hachaton.model.entity.RaexDictionary;

import java.util.List;

public interface RaexDictionaryRepository extends CrudRepository<RaexDictionary, Long> {

    List<RaexDictionary> findAll();

    @Query("SELECT * FROM raex_dict WHERE UPPER(full_name) LIKE '%' UPPER(:full_name) || '%'")
    List<RaexDictionary> findByFullName(@Param("full_name") String name);

    @Query("SELECT * FROM raex_dict WHERE inn = :inn ")
    RaexDictionary findByInn(@Param("inn") String inn);
}
