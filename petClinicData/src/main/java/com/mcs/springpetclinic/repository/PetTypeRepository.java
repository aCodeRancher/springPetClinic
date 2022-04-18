package com.mcs.springpetclinic.repository;

import com.mcs.springpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
