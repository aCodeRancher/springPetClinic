package com.mcs.springpetclinic.repository;

import com.mcs.springpetclinic.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeRepository extends JpaRepository<PetType, Long> {
}
