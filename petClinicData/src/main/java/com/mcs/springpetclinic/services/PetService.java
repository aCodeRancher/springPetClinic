package com.mcs.springpetclinic.services;

import com.mcs.springpetclinic.model.Pet;
import com.mcs.springpetclinic.services.jpa.CrudJpaService;

public interface PetService extends CrudJpaService<Pet> {
}
