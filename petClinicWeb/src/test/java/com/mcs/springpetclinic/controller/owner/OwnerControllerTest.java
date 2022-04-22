package com.mcs.springpetclinic.controller.owner;

import com.mcs.springpetclinic.controllers.owner.OwnerController;
import com.mcs.springpetclinic.model.Owner;
import com.mcs.springpetclinic.services.OwnerService;
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
class OwnerControllerTest {

    @InjectMocks
    private OwnerController controller;

    @Mock
    private OwnerService service;

    private List<Owner> owners;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        owners = Collections.singletonList(Owner.builder().id(1L).build());
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @ParameterizedTest
    @ValueSource(strings = {"/owners", "/owners/", "/owners/index", "/owners/index.html"})
    void ownerControllerIndexTest(String paths) throws Exception {
        Mockito.when(service.findAll())
                .thenReturn(owners);

        mockMvc.perform(get(paths))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(1)));
    }
}
