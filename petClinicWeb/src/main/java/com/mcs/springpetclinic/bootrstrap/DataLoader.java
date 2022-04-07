package com.mcs.springpetclinic.bootrstrap;

import com.mcs.springpetclinic.model.Owner;
import com.mcs.springpetclinic.model.Person;
import com.mcs.springpetclinic.model.Vet;
import com.mcs.springpetclinic.services.OwnerService;
import com.mcs.springpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) {

        ownerService.saveAll(Set.of(
                new Owner.OwnerBuilder().firstName("anna").lastName("lee").build(),
                new Owner.OwnerBuilder().firstName("john").lastName("thompson").build()
        ));
        
        vetService.saveAll(Set.of(
                new Vet.VetBuilder().lastName("collins").firstName("bill").build(),
                new Vet.VetBuilder().lastName("reeves").firstName("keanu").build()
        ));

        System.out.println("Bootstrap data loader...");
        System.out.println("Owners: " + ownerService.findAll());
        System.out.println("Vets: " + vetService.findAll());
    }
}
