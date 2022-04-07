package com.mcs.springpetclinic.services.map;

import com.mcs.springpetclinic.model.Vet;
import com.mcs.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
}
