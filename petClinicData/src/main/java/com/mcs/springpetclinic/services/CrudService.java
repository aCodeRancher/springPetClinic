package com.mcs.springpetclinic.services;

import java.util.Set;

public interface CrudService<S, ID> {

    S save(S service);

    S findById(ID id);

    Set<S> findAll();

    void delete(S service);

    void deleteById(ID id);

}
