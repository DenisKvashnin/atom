package ru.atom.hachaton.service.local;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.atom.hachaton.model.entity.AtomCityDictionary;
import ru.atom.hachaton.repository.AtomCityDictionaryRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AtomCityDictionaryService {

    private final AtomCityDictionaryRepository repository;

    public AtomCityDictionaryService(AtomCityDictionaryRepository repository) {
        this.repository = repository;
    }

    public List<AtomCityDictionary> findAll(){
        return repository.findAll();
    }

    @Cacheable("setsCityName")
    public Set<String> getSetsCityName(){
        List<AtomCityDictionary> atomCityDictionaries = repository.findAll();
        Set<String> resultSet = new HashSet<>();
        for(AtomCityDictionary a : atomCityDictionaries){
            resultSet.add(a.getCity().toUpperCase());
        }
        return resultSet;
    }

    public Optional<AtomCityDictionary> findById(Long id){
        return repository.findById(id);
    }
}
