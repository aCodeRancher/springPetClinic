package com.mcs.springpetclinic.bootrstrap;

import com.mcs.springpetclinic.model.*;
import com.mcs.springpetclinic.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    @Autowired
    public DataLoader(
            OwnerService ownerService,
            VetService vetService,
            PetTypeService petTypeService,
            PetService petService,
            SpecialityService specialityService,
            VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {
        if (petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        log.debug("Bootstrap data loader...");

        // Pet Type Data Boot
        PetType dogPetType = new PetType();
        dogPetType.setName("Dog");

        // Owners Data Boot
        Owner john = new Owner();
        john.setFirstName("john");
        john.setLastName("thompson");
        john.setAddress("Times Square");
        john.setCity("NY");
        john.setPhone("123");

        // John Pet Data Boot
        Pet johnPet = new Pet();
        johnPet.setPetType(dogPetType);
        johnPet.setOwner(john);
        johnPet.setName("Brian");
        johnPet.setBirthday(LocalDate.of(2010, 9, 23));
        john.getPets().add(johnPet);

        // Vet Data Boot
        Vet anna = new Vet();
        anna.setFirstName("anna");
        anna.setLastName("lee");
        anna.setAddress("Breek");
        anna.setCity("California");
        anna.setPhone("1234");

        // Speciality Data Boot
        Speciality annaSpeciality = new Speciality();
        annaSpeciality.setDescription("surgery");
        anna.getSpecialities().add(annaSpeciality);

        // Visit Data Boot
        Visit johnDogVisit = new Visit();
        johnDogVisit.setPet(johnPet);
        johnDogVisit.setDescription("Runny nose");
        johnDogVisit.setDate(LocalDateTime.now());

        petService.save(johnPet);
        petTypeService.save(dogPetType);
        ownerService.saveAll(Set.of(john));
        specialityService.saveAll(Set.of(annaSpeciality));
        vetService.saveAll(Set.of(anna));
        visitService.save(johnDogVisit);

        log.debug("Data loaded successfully...");
    }
}
