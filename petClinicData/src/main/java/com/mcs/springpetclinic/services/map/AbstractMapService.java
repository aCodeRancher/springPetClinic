package com.mcs.springpetclinic.services.map;

import com.mcs.springpetclinic.exceptions.AbstractMapException;
import com.mcs.springpetclinic.model.BaseEntity;
import com.mcs.springpetclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService<S extends BaseEntity, ID extends Long> implements CrudService<S, ID> {

    protected Map<Long, S> map = new HashMap<>();

    @Override
    public S save(S service) {
        if (service != null) {

            if (service.getId() == null) {
                map.put(generateNextId(), service);
            } else {
                map.put(service.getId(), service);
            }

        } else {
            throw new AbstractMapException("Can't save empty service");
        }
        return service;
    }

    @Override
    public void saveAll(Set<S> services) {
        for (S service : services) {
            this.save(service);
        }
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

    private Long generateNextId() {
        if (map.isEmpty()) return 1L;

        return Collections.max(map.keySet()) + 1L;
    }
}
