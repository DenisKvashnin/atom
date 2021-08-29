package ru.atom.hachaton.service.communicate.rest;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import ru.atom.hachaton.config.feign.FeignDaDataConfiguration;
import ru.atom.hachaton.model.data.out.dadata.DaDataResponseDto;
import ru.atom.hachaton.model.dto.in.DaDataRequestDto;

@FeignClient(
        value = "find-organization-by-inn",
        url = "${outer.services.daDataAdapter.findOrganizationByInn.url}",
        configuration = FeignDaDataConfiguration.class
)
public interface DaDataAdapterOuterService {

    @PostMapping
    DaDataResponseDto findOrganizationByInn(@RequestBody DaDataRequestDto request);
}
