package ru.atom.hachaton.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.atom.hachaton.model.data.out.dadata.DaDataResponseDto;
import ru.atom.hachaton.model.dto.in.DaDataRequestDto;
import ru.atom.hachaton.service.communicate.rest.DaDataAdapterOuterService;

@RestController
@RequestMapping("/dadata")
public class DaDataController {

    private final DaDataAdapterOuterService daDataAdapterOuterService;

    public DaDataController(DaDataAdapterOuterService daDataAdapterOuterService) {
        this.daDataAdapterOuterService = daDataAdapterOuterService;
    }

    @GetMapping
    public ResponseEntity<DaDataResponseDto> findByInn(@RequestParam("inn") String inn) {
        DaDataResponseDto str = daDataAdapterOuterService.findOrganizationByInn(new DaDataRequestDto(inn));
        return ResponseEntity.ok(str);
    }
}
