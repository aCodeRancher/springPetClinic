package com.mcs.springpetclinic.repository;

import com.mcs.springpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
