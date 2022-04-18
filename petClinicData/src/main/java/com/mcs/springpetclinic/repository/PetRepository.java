package com.mcs.springpetclinic.repository;

import com.mcs.springpetclinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
