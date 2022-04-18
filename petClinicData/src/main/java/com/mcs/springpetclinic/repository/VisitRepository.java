package com.mcs.springpetclinic.repository;

import com.mcs.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
