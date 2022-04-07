package com.mcs.springpetclinic.services.map;

import com.mcs.springpetclinic.model.Pet;
import com.mcs.springpetclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
}
