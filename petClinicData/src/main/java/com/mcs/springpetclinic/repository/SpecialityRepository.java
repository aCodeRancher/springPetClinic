package com.mcs.springpetclinic.repository;

import com.mcs.springpetclinic.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}
