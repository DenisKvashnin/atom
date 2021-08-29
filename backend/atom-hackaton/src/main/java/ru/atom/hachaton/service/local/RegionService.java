package ru.atom.hachaton.service.local;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.atom.hachaton.model.entity.Region;
import ru.atom.hachaton.repository.RegionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    private final RegionRepository repository;

    public RegionService(RegionRepository repository) {
        this.repository = repository;
    }

    @Cacheable("regionAll")
    public List<Region> findAll(){
        return repository.findAll();
    }

    public Optional<Region> findById(Long id){
        return repository.findById(id);
    }
}
