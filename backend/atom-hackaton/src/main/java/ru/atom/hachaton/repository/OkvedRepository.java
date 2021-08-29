package ru.atom.hachaton.repository;

import org.springframework.data.repository.CrudRepository;
import ru.atom.hachaton.model.entity.Okved;

import java.util.List;

public interface OkvedRepository extends CrudRepository<Okved, String> {
    List<Okved> findAll();
}
