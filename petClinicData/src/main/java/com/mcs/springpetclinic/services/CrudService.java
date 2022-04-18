package com.mcs.springpetclinic.services;

import com.mcs.springpetclinic.model.BaseEntity;

import java.util.Set;

public interface CrudService<S extends BaseEntity> {

    S save(S service);

    void saveAll(Set<S> services);

    S findById(Long id);

    Set<S> findAll();

    void delete(S service);

    void deleteById(Long id);

}
