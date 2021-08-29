package ru.atom.hachaton.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.atom.hachaton.model.entity.Region;
import ru.atom.hachaton.repository.MapRepository;
import ru.atom.hachaton.repository.RegionRepository;
import ru.atom.hachaton.service.local.MapService;
import ru.atom.hachaton.service.local.RegionService;

@ContextConfiguration(classes = {RegionController.class})
@ExtendWith(SpringExtension.class)
public class RegionControllerTest {
    @MockBean
    private MapService mapService;

    @Autowired
    private RegionController regionController;

    @MockBean
    private RegionService regionService;

    @Test
    public void testConstructor() {
        RegionService regionService = new RegionService(mock(RegionRepository.class));
        ResponseEntity<List<Region>> findAllResult = (new RegionController(regionService,
                new MapService(mock(MapRepository.class)))).findAll();
        assertTrue(findAllResult.getBody().isEmpty());
        assertEquals("<200 OK OK,[],[]>", findAllResult.toString());
        assertTrue(findAllResult.hasBody());
        assertEquals(200, findAllResult.getStatusCodeValue());
        assertEquals(HttpStatus.OK, findAllResult.getStatusCode());
        assertTrue(findAllResult.getHeaders().isEmpty());
        assertTrue(regionService.findAll().isEmpty());
    }

    @Test
    public void testFindAll() throws Exception {
        when(this.regionService.findAll()).thenReturn(new ArrayList<Region>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/region");
        MockMvcBuilders.standaloneSetup(this.regionController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    public void testFindById() throws Exception {
        Region region = new Region();
        region.setNameRu("Name Ru");
        region.setPathImage("Path Image");
        region.setId(123L);
        region.setNameEng("Name Eng");
        Optional<Region> ofResult = Optional.<Region>of(region);
        when(this.regionService.findById((Long) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/region/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.regionController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":123,\"nameRu\":\"Name Ru\",\"nameEng\":\"Name Eng\",\"pathImage\":\"Path Image\"}"));
    }

    @Test
    public void testFindById2() throws Exception {
        when(this.regionService.findById((Long) any())).thenReturn(Optional.<Region>empty());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/region/{id}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.regionController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}

