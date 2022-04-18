package com.mcs.springpetclinic.repository;

import com.mcs.springpetclinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
