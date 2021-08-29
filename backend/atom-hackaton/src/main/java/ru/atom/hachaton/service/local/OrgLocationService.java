package ru.atom.hachaton.service.local;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.atom.hachaton.model.entity.OrgLocation;
import ru.atom.hachaton.repository.OrgLocationRepository;

import java.util.List;

@Slf4j
@Service
public class OrgLocationService {

    private final OrgLocationRepository repository;

    public OrgLocationService(OrgLocationRepository repository) {
        this.repository = repository;
    }

    public List<OrgLocation> findByOrgId(Long orgId){
        return repository.findByOrgId(orgId);
    }
}
