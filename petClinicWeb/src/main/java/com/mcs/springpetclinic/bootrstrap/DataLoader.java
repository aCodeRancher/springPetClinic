package com.mcs.springpetclinic.bootrstrap;

import com.mcs.springpetclinic.model.*;
import com.mcs.springpetclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;

    @Autowired
    public DataLoader(
            OwnerService ownerService,
            VetService vetService,
            PetTypeService petTypeService,
            PetService petService,
            SpecialityService specialityService
    ) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) {
        if (petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        System.out.println("Bootstrap data loader...");

        // Pet Type Data Boot
        PetType dogPetType = new PetType();
        dogPetType.setName("Dog");
        dogPetType = petTypeService.save(dogPetType);

        PetType catPetType = new PetType();
        catPetType.setName("Cat");
        catPetType = petTypeService.save(catPetType);

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

        Owner mark = new Owner();
        mark.setFirstName("mark");
        mark.setLastName("collins");
        mark.setLastName("thompson");
        mark.setAddress("Golden Beach");
        mark.setCity("California");
        mark.setPhone("456");

        // John Pet Data Boot
        Pet markPet = new Pet();
        markPet.setPetType(catPetType);
        markPet.setOwner(mark);
        markPet.setName("Molly");
        markPet.setBirthday(LocalDate.of(2019, 2, 3));
        mark.getPets().add(markPet);

        ownerService.saveAll(Set.of(john, mark));

        // Vet Data Boot
        Vet bill = new Vet();
        bill.setFirstName("bill");
        bill.setLastName("milligan");
        bill.setAddress("Madison");
        bill.setCity("NY");
        bill.setPhone("890");
        Speciality billSpeciality = new Speciality();
        billSpeciality.setDescription("radiology");
        bill.getSpecialities().add(billSpeciality);

        Vet anna = new Vet();
        anna.setFirstName("anna");
        anna.setLastName("lee");
        anna.setAddress("Breek");
        anna.setCity("California");
        anna.setPhone("1234");
        Speciality annaSpeciality = new Speciality();
        annaSpeciality.setDescription("surgery");
        anna.getSpecialities().add(annaSpeciality);

        vetService.saveAll(Set.of(bill, anna));

        ownerService.findAll().forEach(System.out::println);
        vetService.findAll().forEach(System.out::println);

    }
}
