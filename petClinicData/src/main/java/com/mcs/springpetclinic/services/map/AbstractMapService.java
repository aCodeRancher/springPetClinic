package com.mcs.springpetclinic.services.map;

import com.mcs.springpetclinic.model.BaseEntity;
import com.mcs.springpetclinic.services.CrudService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<S extends BaseEntity, ID extends Long> implements CrudService<S, ID> {

    protected Map<ID, S> map = new HashMap<>();

    @Override
    @SuppressWarnings("unchecked")
    public S save(S service) {
        map.put((ID) service.getId(), service);
        return service;
    }

    @Override
    public S findById(ID id) {
        return map.get(id);
    }

    @Override
    public Set<S> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public void delete(S service) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(service));
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }
}
