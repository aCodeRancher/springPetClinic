package com.mcs.springpetclinic.repository;

import com.mcs.springpetclinic.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {
}
