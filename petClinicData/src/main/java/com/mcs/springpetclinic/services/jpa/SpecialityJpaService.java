package com.mcs.springpetclinic.services.jpa;

import com.mcs.springpetclinic.model.Speciality;
import com.mcs.springpetclinic.repository.SpecialityRepository;
import com.mcs.springpetclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityJpaService
        extends AbstractJpaService<Speciality, SpecialityRepository>
        implements SpecialityService {

    public SpecialityJpaService(SpecialityRepository repository) {
        super(repository);
    }
}
