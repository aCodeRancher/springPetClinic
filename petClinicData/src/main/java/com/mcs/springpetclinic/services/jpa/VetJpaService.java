package com.mcs.springpetclinic.services.jpa;

import com.mcs.springpetclinic.model.Vet;
import com.mcs.springpetclinic.repository.VetRepository;
import com.mcs.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetJpaService extends AbstractJpaService<Vet, VetRepository> implements VetService {

    public VetJpaService(VetRepository repository) {
        super(repository);
    }
}
