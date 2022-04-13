package com.mcs.springpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Vet extends Person {

    private Set<Speciality> specialities = new HashSet<>();

    @Override
    public String toString() {
        return super.toString() + " " +
                "Vet{" +
                "specialties=" + specialities +
                '}';
    }
}
