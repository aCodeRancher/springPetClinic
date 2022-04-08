package com.mcs.springpetclinic.bootrstrap;

import com.mcs.springpetclinic.model.Owner;
import com.mcs.springpetclinic.model.Vet;
import com.mcs.springpetclinic.services.OwnerService;
import com.mcs.springpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
        value="spring.profiles.active",
        havingValue = "setter")
public class DataLoaderSetter implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoaderSetter(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Data loader setter");

        Owner john = new Owner();
        john.setFirstName("john");
        john.setLastName("thompson");

        ownerService.save(john);

        Vet bill = new Vet();
        bill.setFirstName("bill");
        bill.setLastName("milligan");

        vetService.save(bill);

        System.out.println("Owners: " + ownerService.findAll());
        System.out.println("Vetss: " + vetService.findAll());

    }
}
