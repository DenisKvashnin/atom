package ru.atom.hachaton.repository;

import org.springframework.data.repository.CrudRepository;
import ru.atom.hachaton.model.entity.OrgLocation;

import java.util.List;

public interface OrgLocationRepository extends CrudRepository<OrgLocation, Long> {
     List<OrgLocation> findByOrgId(Long id);
}
