package ru.atom.hachaton.service.local;

import org.springframework.stereotype.Service;
import ru.atom.hachaton.model.entity.Okved;
import ru.atom.hachaton.repository.OkvedRepository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class OkvedService {

    private final OkvedRepository okvedRepository;

    public OkvedService(OkvedRepository okvedRepository) {
        this.okvedRepository = okvedRepository;
    }

    public List<Okved> findAll(){
        return okvedRepository.findAll();
    }

    public Optional<Okved> findByCode(@NotNull String code){
        return okvedRepository.findById(code);
    }
}
