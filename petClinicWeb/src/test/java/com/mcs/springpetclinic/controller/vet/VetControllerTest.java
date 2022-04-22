package com.mcs.springpetclinic.controller.vet;

import com.mcs.springpetclinic.controllers.vet.VetController;
import com.mcs.springpetclinic.model.Vet;
import com.mcs.springpetclinic.services.VetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class VetControllerTest {

    @Mock
    VetService service;

    @InjectMocks
    VetController controller;

    List<Vet> vets;

    MockMvc mockMvc;

    final String VIEW_NAME = "vets/index";

    final String VET_ATTRIBUTE = "vets";

    @BeforeEach
    void setup() {
        vets = Collections.singletonList(Vet.builder().id(1L).build());
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @ParameterizedTest
    @ValueSource(strings = {"/vets", "/vets/", "/vets/index", "/vets/index.html"})
    void ownerControllerIndexTest(String paths) throws Exception {
        Mockito.when(service.findAll())
                .thenReturn(vets);

        mockMvc.perform(get(paths))
                .andExpect(status().isOk())
                .andExpect(view().name(VIEW_NAME))
                .andExpect(model().attribute(VET_ATTRIBUTE, hasSize(1)));
    }
}
