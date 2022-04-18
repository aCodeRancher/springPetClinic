package com.mcs.springpetclinic.services.jpa;

import com.mcs.springpetclinic.model.PetType;
import com.mcs.springpetclinic.repository.PetTypeRepository;
import com.mcs.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeJpaService
        extends AbstractJpaService<PetType, PetTypeRepository>
        implements PetTypeService {

    public PetTypeJpaService(PetTypeRepository repository) {
        super(repository);
    }
}
