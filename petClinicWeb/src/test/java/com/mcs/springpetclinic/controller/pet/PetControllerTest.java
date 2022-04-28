package com.mcs.springpetclinic.controller.pet;

import com.mcs.springpetclinic.controllers.pet.PetController;
import com.mcs.springpetclinic.model.Owner;
import com.mcs.springpetclinic.model.Pet;
import com.mcs.springpetclinic.services.OwnerService;
import com.mcs.springpetclinic.services.PetService;
import com.mcs.springpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PetControllerTest {

    @InjectMocks
    PetController petController;

    @Mock
    OwnerService ownerService;

    @Mock
    PetTypeService petTypeService;

    @Mock
    PetService petService;

    Owner owner;

    List<Pet> pets;

    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        owner = Owner.builder().id(1L).build();
        pets = List.of(
                Pet.builder().id(1L).owner(owner).build(),
                Pet.builder().id(2L).owner(owner).build());
        mockMvc = MockMvcBuilders.standaloneSetup(petController).build();
    }
}
