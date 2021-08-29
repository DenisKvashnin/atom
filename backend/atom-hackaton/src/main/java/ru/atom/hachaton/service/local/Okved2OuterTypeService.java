package ru.atom.hachaton.service.local;

import org.springframework.stereotype.Service;
import ru.atom.hachaton.model.entity.Okved2OuterOrgType;
import ru.atom.hachaton.repository.Okved2OuterTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class Okved2OuterTypeService {

    private final Okved2OuterTypeRepository repository;

    public Okved2OuterTypeService(Okved2OuterTypeRepository repository) {
        this.repository = repository;
    }

    public List<Okved2OuterOrgType> findAll(){
        return repository.findAll();
    }

    public Optional<Okved2OuterOrgType> findById(Long id){
        return repository.findById(id);
    }

    public List<String> find(List<Long> types) {
        return repository.findOkvedCodes(types);
    }
}
