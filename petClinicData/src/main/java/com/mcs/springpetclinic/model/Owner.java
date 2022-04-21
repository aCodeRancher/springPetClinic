package com.mcs.springpetclinic.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "owners")
public class Owner extends Person {

    @Builder
    public Owner(
            Long id,
            String firstName,
            String lastName,
            String address,
            String city,
            String phone,
            Set<Pet> pets
    ) {
        super(id, firstName, lastName, address, city, phone);

        if(pets != null) {
            this.pets = pets;
        }
    }

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();
}
