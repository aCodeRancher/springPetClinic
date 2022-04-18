package com.mcs.springpetclinic.services.map;

import com.mcs.springpetclinic.model.Pet;
import com.mcs.springpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
}
