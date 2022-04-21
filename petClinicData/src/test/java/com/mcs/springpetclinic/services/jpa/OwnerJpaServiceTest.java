package com.mcs.springpetclinic.services.jpa;

import com.mcs.springpetclinic.model.Owner;
import com.mcs.springpetclinic.repository.OwnerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    String LAST_NAME = "Smith";
    Owner OWNER = Owner.builder().id(1L).lastName(LAST_NAME).build();

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerJpaService ownerService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAllTest() {
        List<Owner> owners = Collections.singletonList(Owner.builder().id(1L).build());

        when(ownerRepository.findAll())
                .thenReturn(owners);

        Assertions.assertEquals(1, ownerRepository.findAll().size());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any()))
                .thenReturn(OWNER);

        Assertions.assertEquals(OWNER, ownerService.findByLastName(LAST_NAME));
    }

    @Test
    void findByIdTest() {
        when(ownerRepository.findById(any()))
                .thenReturn(Optional.of(OWNER));

        Assertions.assertEquals(OWNER, ownerService.findById(1L));
    }

    @Test
    void saveTest() {
        ownerRepository.save(any());
        verify(ownerRepository, times(1)).save(any());
    }

    @Test
    void deleteByIdTest() {
        ownerRepository.deleteById(anyLong());
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }

}