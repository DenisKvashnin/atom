package ru.atom.hachaton.repository;

import org.springframework.data.repository.CrudRepository;
import ru.atom.hachaton.model.entity.OuterOrgType;

import java.util.List;

public interface OuterOrgTypeRepository extends CrudRepository<OuterOrgType, Long> {
    List<OuterOrgType> findAll();
}
