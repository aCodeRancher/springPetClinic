package com.mcs.springpetclinic.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
public class Vet extends Person {

    private Set<Specialty> specialties;

    @Override
    public String toString() {
        return super.toString() + " " +
                "Vet{" +
                "specialties=" + specialties +
                '}';
    }
}
