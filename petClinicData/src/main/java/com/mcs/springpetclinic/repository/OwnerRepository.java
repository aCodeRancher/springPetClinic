package com.mcs.springpetclinic.repository;

import com.mcs.springpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
