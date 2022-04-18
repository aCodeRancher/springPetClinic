package com.mcs.springpetclinic.services.jpa;

import com.mcs.springpetclinic.model.Pet;
import com.mcs.springpetclinic.repository.PetRepository;
import com.mcs.springpetclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetJpaService extends AbstractJpaService<Pet, PetRepository> implements PetService {

    public PetJpaService(PetRepository repository) {
        super(repository);
    }
}
