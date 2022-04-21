package com.mcs.springpetclinic.jpaservice;

import com.mcs.springpetclinic.model.Owner;
import com.mcs.springpetclinic.repository.OwnerRepository;
import com.mcs.springpetclinic.services.jpa.OwnerJpaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class OwnerJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    OwnerJpaService ownerJpaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        ownerJpaService = new OwnerJpaService(ownerRepository);
    }

    @Test
    public void findByIdTest() {
        // arrange
        List<Owner> ownerData = List.of(new Owner());

        // act
        Mockito.when(ownerRepository.findAll())
                .thenReturn(ownerData);

        // assert
        Assertions.assertEquals(1, ownerRepository.findAll().size());
    }
}
