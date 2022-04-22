package com.mcs.springpetclinic.jpaservice;

import com.mcs.springpetclinic.model.Owner;
import com.mcs.springpetclinic.repository.OwnerRepository;
import com.mcs.springpetclinic.services.jpa.OwnerJpaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class OwnerJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    OwnerJpaService ownerJpaService;

    @BeforeEach
    void setup() {
        openMocks(this);
        ownerJpaService = new OwnerJpaService(ownerRepository);
    }

    @Test
    void findByIdTest() {
        // arrange
        List<Owner> ownerData = List.of(new Owner());

        // act
        when(ownerRepository.findAll())
                .thenReturn(ownerData);

        // assert
        assertEquals(1, ownerRepository.findAll().size());
    }
}
