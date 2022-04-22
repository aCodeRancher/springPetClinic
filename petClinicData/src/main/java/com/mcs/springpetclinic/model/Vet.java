package com.mcs.springpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vets")
public class Vet extends Person {

    @Builder
    public Vet(
            Long id,
            String firstName,
            String lastName,
            String address,
            String city,
            String phone,
            Set<Speciality> specialities
    ) {
        super(id, firstName, lastName, address, city, phone);

        if(specialities != null) {
            this.specialities = specialities;
        }
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "vet_specialties",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();

}
