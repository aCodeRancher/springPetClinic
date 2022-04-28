package com.mcs.springpetclinic.repository;

import com.mcs.springpetclinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(@Param("lastName") String lastName);

    List<Owner> findAllByLastNameContaining(String lastName);

    @Query("SELECT DISTINCT owner FROM Owner owner WHERE lower(owner.lastName) LIKE lower(concat('%', :lastName, '%'))")
    List<Owner> findAllByLastNameContainingIgnoreCase(String lastName);
}
