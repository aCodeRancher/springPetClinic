package com.mcs.springpetclinic.services;

import com.mcs.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner> {

    Owner findByLastName(String lastName);

}
