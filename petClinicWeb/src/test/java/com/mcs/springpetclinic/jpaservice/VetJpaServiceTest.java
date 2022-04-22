package com.mcs.springpetclinic.jpaservice;

import com.mcs.springpetclinic.model.Owner;
import com.mcs.springpetclinic.model.Vet;
import com.mcs.springpetclinic.repository.VetRepository;
import com.mcs.springpetclinic.services.jpa.OwnerJpaService;
import com.mcs.springpetclinic.services.jpa.VetJpaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VetJpaServiceTest {

    @Mock
    VetRepository repository;

    @InjectMocks
    VetJpaService service;

    @Test
    void findByIdTest() {
        // arrange
        List<Vet> vets = List.of(new Vet());

        // act
        when(repository.findAll())
                .thenReturn(vets);

        // assert
        Assertions.assertEquals(1, service.findAll().size());
        verify(repository).findAll();
    }

}
