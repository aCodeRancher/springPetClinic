package com.mcs.springpetclinic.repository;

import com.mcs.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
