package ru.atom.hachaton.repository;

import org.springframework.data.repository.CrudRepository;
import ru.atom.hachaton.model.entity.AtomCityDictionary;

import java.util.List;

public interface AtomCityDictionaryRepository extends CrudRepository<AtomCityDictionary, Long> {
    List<AtomCityDictionary> findAll();
}
