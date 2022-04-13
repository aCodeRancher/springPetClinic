package com.mcs.springpetclinic.services.map;

import com.mcs.springpetclinic.model.Specialty;
import com.mcs.springpetclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityMapService extends AbstractMapService<Specialty, Long> implements SpecialityService {
}
