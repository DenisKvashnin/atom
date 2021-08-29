package ru.atom.hachaton.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.atom.hachaton.model.dto.out.OrgAddressDto;
import ru.atom.hachaton.model.dto.out.OrgTypeCountDto;
import ru.atom.hachaton.model.dto.out.OrgTypeCountListDto;
import ru.atom.hachaton.model.dto.out.OrganizationContainerDto;
import ru.atom.hachaton.model.entity.Organization;
import ru.atom.hachaton.repository.AtomCityDictionaryRepository;
import ru.atom.hachaton.repository.MapRepository;
import ru.atom.hachaton.repository.Okved2OuterTypeRepository;
import ru.atom.hachaton.repository.OrganizationRepository;
import ru.atom.hachaton.repository.RaexDictionaryRepository;
import ru.atom.hachaton.repository.RegionRepository;
import ru.atom.hachaton.service.local.AtomCityDictionaryService;
import ru.atom.hachaton.service.local.MapService;
import ru.atom.hachaton.service.local.Okved2OuterTypeService;
import ru.atom.hachaton.service.local.OrganizationService;
import ru.atom.hachaton.service.local.RaexDictionaryService;
import ru.atom.hachaton.service.local.RegionService;
import ru.atom.hachaton.service.processing.OrganizationProcessingService;

@ContextConfiguration(classes = {OrganizationController.class})
@ExtendWith(SpringExtension.class)
public class OrganizationControllerTest {
    @Autowired
    private OrganizationController organizationController;

    @MockBean
    private OrganizationProcessingService organizationProcessingService;

    @MockBean
    private OrganizationService organizationService;

    @Test
    public void testConstructor() {
        OrganizationRepository repository = mock(OrganizationRepository.class);
        MapService mapService = new MapService(mock(MapRepository.class));
        Okved2OuterTypeService okved2OuterTypeService = new Okved2OuterTypeService(mock(Okved2OuterTypeRepository.class));
        RegionService regionService = new RegionService(mock(RegionRepository.class));
        RaexDictionaryService raexDictionaryService = new RaexDictionaryService(mock(RaexDictionaryRepository.class));
        OrganizationService organizationService = new OrganizationService(repository, mapService, okved2OuterTypeService,
                regionService, raexDictionaryService, new AtomCityDictionaryService(mock(AtomCityDictionaryRepository.class)));

        new OrganizationController(organizationService,
                new OrganizationProcessingService(mock(OrganizationRepository.class)));

    }

    @Test
    public void testFindById() throws Exception {
        Organization organization = new Organization();
        organization.setLat("Lat");
        organization.setInn("Inn");
        organization.setName("Name");
        organization.setAddress("42 Main St");
        organization.setOkved("Okved");
        organization.setSite("Site");
        organization.setStatus("Status");
        organization.setOkvedName("Okved Name");
        organization.setCity("Oxford");
        organization.setId(123L);
        organization.setLon("Lon");
        organization.setIndex("Index");
        organization.setTimezone("Timezone");
        Optional<Organization> ofResult = Optional.<Organization>of(organization);
        when(this.organizationService.findById((Long) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/org/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.organizationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"okved\":\"Okved\",\"okvedName\":\"Okved Name\",\"inn\":\"Inn\",\"address\":\"42 Main"
                                        + " St\",\"index\":\"Index\",\"site\":\"Site\",\"city\":\"Oxford\",\"timezone\":\"Timezone\",\"status\":\"Status\",\"lat\":\"Lat"
                                        + "\",\"lon\":\"Lon\"}"));
    }

    @Test
    public void testFindById2() throws Exception {
        when(this.organizationService.findById((Long) any())).thenReturn(Optional.<Organization>empty());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/org/{id}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.organizationController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void testAddress() throws Exception {
        when(this.organizationService.address()).thenReturn(new ArrayList<OrgAddressDto>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/org/address");
        MockMvcBuilders.standaloneSetup(this.organizationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    public void testStatOrganization() throws Exception {
        OrgTypeCountListDto orgTypeCountListDto = new OrgTypeCountListDto();
        orgTypeCountListDto.setRegionStatistics(new HashMap<String, OrgTypeCountDto>(1));
        when(this.organizationProcessingService.findEduOrganization()).thenReturn(orgTypeCountListDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/org/statistics");
        MockMvcBuilders.standaloneSetup(this.organizationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"regionStatistics\":{}}"));
    }
}

