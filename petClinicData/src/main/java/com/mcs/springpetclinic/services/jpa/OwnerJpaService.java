package com.mcs.springpetclinic.services.jpa;

import com.mcs.springpetclinic.model.Owner;
import com.mcs.springpetclinic.repository.OwnerRepository;
import com.mcs.springpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerJpaService extends AbstractJpaService<Owner, OwnerRepository> implements OwnerService {

    public OwnerJpaService(OwnerRepository repository) {
        super(repository);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameContainingIgnoreCase(String lastName) {
        return repository.findAllByLastNameContainingIgnoreCase(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return repository.findAllByLastNameLike(lastName);
    }
}
