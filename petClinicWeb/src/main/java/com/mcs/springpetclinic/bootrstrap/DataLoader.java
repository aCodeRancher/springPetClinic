package com.mcs.springpetclinic.bootrstrap;

import com.mcs.springpetclinic.model.Owner;
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
        System.out.println("Bootstrap data loader...");

        ownerService.saveAll(Set.of(
                new Owner("john", "thompson"),
                new Owner("anna", "lee")));

        vetService.saveAll(Set.of(
                new Vet("bill", "billigan"),
                new Vet("carry", "carrygan")));

        System.out.println("Owners: " + ownerService.findAll());
        System.out.println("Vets: " + vetService.findAll());
    }
}
