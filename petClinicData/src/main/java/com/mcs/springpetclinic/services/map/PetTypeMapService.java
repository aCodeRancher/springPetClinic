package com.mcs.springpetclinic.services.map;

import com.mcs.springpetclinic.model.PetType;
import com.mcs.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}
