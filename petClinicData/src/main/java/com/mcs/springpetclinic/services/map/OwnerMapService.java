package com.mcs.springpetclinic.services.map;

import com.mcs.springpetclinic.model.Owner;
import com.mcs.springpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner save(Owner owner) {
        if (owner != null && owner.getPets().size() > 0) {
            owner.getPets().forEach(pet -> {
                if (pet.getId() == null) {
                    pet.setId(generateNextId());
                }
            });
            return super.save(owner);

        } else {
            return new Owner();
        }
    }

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
