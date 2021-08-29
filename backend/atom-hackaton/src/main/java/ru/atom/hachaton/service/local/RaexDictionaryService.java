package ru.atom.hachaton.service.local;

import org.springframework.stereotype.Service;
import ru.atom.hachaton.model.entity.RaexDictionary;
import ru.atom.hachaton.repository.RaexDictionaryRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RaexDictionaryService {

    private final RaexDictionaryRepository raexDictionaryRepository;

    public RaexDictionaryService(RaexDictionaryRepository raexDictionaryRepository) {
        this.raexDictionaryRepository = raexDictionaryRepository;
    }

    public List<RaexDictionary> findAll() {
        return raexDictionaryRepository.findAll();
    }

    public Set<String> getRaexFullSet() {
        List<RaexDictionary> raexDictionaries = raexDictionaryRepository.findAll();
        Set<String> raexSet = new HashSet<>();
        for (RaexDictionary r : raexDictionaries) {
            if (r.getInn() != null) {
                raexSet.add(r.getInn());
            }
        }
        return raexSet;
    }

    public RaexDictionary raex(String inn){
       return  raexDictionaryRepository.findByInn(inn);
    }
}

