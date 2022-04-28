package com.mcs.springpetclinic.services.jpa;

import java.util.List;
import java.util.Set;

public interface CrudJpaService<T> {

    T save(T service);

    void saveAll(Set<T> services);

    T findById(Long id);

    List<T> findAll();

    void delete(T service);

    void deleteById(Long id);
}
