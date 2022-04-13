package com.mcs.springpetclinic.services.map;

import com.mcs.springpetclinic.model.Vet;
import com.mcs.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Vet save(Vet vet) {
        if (vet != null && vet.getSpecialities().size() > 0) {
            vet.getSpecialities().forEach(spec -> {
                if (spec.getId() == null) {
                    spec.setId(generateNextId());
                }
            });
            return super.save(vet);

        } else {
            return new Vet();
        }
    }
}
