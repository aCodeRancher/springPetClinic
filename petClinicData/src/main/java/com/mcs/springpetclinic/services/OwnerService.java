package com.mcs.springpetclinic.services;

import com.mcs.springpetclinic.model.Owner;
import com.mcs.springpetclinic.services.jpa.CrudJpaService;

import java.util.List;

public interface OwnerService extends CrudJpaService<Owner> {

    Owner findByLastName(String lastName);

    List<Owner> findByLastNameLike(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
