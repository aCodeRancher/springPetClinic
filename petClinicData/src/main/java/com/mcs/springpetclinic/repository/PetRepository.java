package com.mcs.springpetclinic.repository;

import com.mcs.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
