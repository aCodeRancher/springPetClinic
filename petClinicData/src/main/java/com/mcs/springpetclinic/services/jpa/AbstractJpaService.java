package com.mcs.springpetclinic.services.jpa;

import com.mcs.springpetclinic.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractJpaService<T extends BaseEntity, R extends JpaRepository<T, Long>>
        implements CrudJpaService<T> {

    protected R repository;

    public AbstractJpaService(R repository) {
        this.repository = repository;
    }

    @Override
    public Set<T> findAll() {
        return new HashSet<>(repository.findAll());
    }

    @Override
    public T findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public T save(T object) {
        return repository.save(object);
    }

    @Override
    public void delete(T object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void saveAll(Set<T> objectSet) {
        repository.saveAll(objectSet);
    }
}
