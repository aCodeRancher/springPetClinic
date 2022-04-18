package com.mcs.springpetclinic.services.map;

import com.mcs.springpetclinic.model.PetType;
import com.mcs.springpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}
