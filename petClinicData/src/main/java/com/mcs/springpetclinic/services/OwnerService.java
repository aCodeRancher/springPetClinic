package com.mcs.springpetclinic.services;

import com.mcs.springpetclinic.model.Owner;
import com.mcs.springpetclinic.services.jpa.CrudJpaService;

public interface OwnerService extends CrudJpaService<Owner> {

    Owner findByLastName(String lastName);

}
