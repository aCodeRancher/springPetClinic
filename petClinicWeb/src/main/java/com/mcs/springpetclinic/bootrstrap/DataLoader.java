package com.mcs.springpetclinic.bootrstrap;

import com.mcs.springpetclinic.model.Owner;
import com.mcs.springpetclinic.model.Vet;
import com.mcs.springpetclinic.services.OwnerService;
import com.mcs.springpetclinic.services.VetService;
import com.mcs.springpetclinic.services.map.OwnerMapService;
import com.mcs.springpetclinic.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerMapService();
        vetService = new VetMapService();
    }

    @Override
    public void run(String... args) {
        System.out.println("Bootstrap data loader...");

        ownerService.saveAll(
                Set.of(
                        new Owner(1L, "john", "thompson"),
                        new Owner(2L, "anna", "lee")
                ));

        vetService.saveAll(
                Set.of(
                        new Vet(1L, "bill", "billigan"),
                        new Vet(2L, "carry", "carrygan")
                )
        );

        System.out.println("Owners: " + ownerService.findAll());
        System.out.println("Vets: " + vetService.findAll());

    }
}
