package com.mcs.springpetclinic.services.map;

import com.mcs.springpetclinic.model.Speciality;
import com.mcs.springpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {
}
