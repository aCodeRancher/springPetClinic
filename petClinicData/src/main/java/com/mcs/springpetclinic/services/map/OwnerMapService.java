package com.mcs.springpetclinic.services.map;

import com.mcs.springpetclinic.model.Owner;
import com.mcs.springpetclinic.services.OwnerService;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public Owner findByLastName(String lastName) {
        return map.entrySet()
                .stream()
                .filter(e -> e.getValue().getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such name: " + lastName))
                .getValue();
    }
}
