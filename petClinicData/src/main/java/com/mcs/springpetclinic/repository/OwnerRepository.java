package com.mcs.springpetclinic.repository;

import com.mcs.springpetclinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

    List<Owner> findAllByLastNameContaining(String lastName);

    List<Owner> findAllByLastNameContainingIgnoreCase(String lastName);
}
