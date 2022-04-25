package com.mcs.springpetclinic.controller.owner;

import com.mcs.springpetclinic.controllers.owner.OwnerController;
import com.mcs.springpetclinic.model.Owner;
import com.mcs.springpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @InjectMocks
    OwnerController controller;

    @Mock
    OwnerService service;

    List<Owner> owners;

    MockMvc mockMvc;

    final String VIEW_NAME = "owners/index";

    final String OWNER_ATTRIBUTE = "owners";

    @BeforeEach
    void setup() {
        owners = Collections.singletonList(Owner.builder().id(1L).build());
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @ParameterizedTest
    @ValueSource(strings = {"/owners", "/owners/", "/owners/index", "/owners/index.html"})
    void ownerControllerIndexTest(String paths) throws Exception {
        when(service.findAll())
                .thenReturn(owners);

        mockMvc.perform(get(paths))
                .andExpect(status().isOk())
                .andExpect(view().name(VIEW_NAME))
                .andExpect(model().attribute(OWNER_ATTRIBUTE, hasSize(1)));
    }

    @Test
    void displayOwner() throws Exception {
        when(service.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());

        mockMvc.perform(get("/owners/123")) // any long value 123
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("id", is(1L))));
    }
}
