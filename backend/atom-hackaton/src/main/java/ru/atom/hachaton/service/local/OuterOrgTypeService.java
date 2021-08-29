package ru.atom.hachaton.service.local;

import org.springframework.stereotype.Service;
import ru.atom.hachaton.model.entity.OuterOrgType;
import ru.atom.hachaton.repository.OuterOrgTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OuterOrgTypeService {

    private final OuterOrgTypeRepository repository;

    public OuterOrgTypeService(OuterOrgTypeRepository repository) {
        this.repository = repository;
    }

    public List<OuterOrgType> findAll(){
        return repository.findAll();
    }

    public Optional<OuterOrgType> findById(Long id){
        return repository.findById(id);
    }
}
