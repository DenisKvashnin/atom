package ru.atom.hachaton.repository;

import org.springframework.data.repository.CrudRepository;
import ru.atom.hachaton.model.entity.Region;

import java.util.List;

public interface RegionRepository extends CrudRepository<Region, Long> {
    List<Region> findAll();
}
