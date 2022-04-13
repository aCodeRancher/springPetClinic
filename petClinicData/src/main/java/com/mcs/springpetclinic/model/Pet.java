package com.mcs.springpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Pet extends NameEntity {

    private Owner owner;
    private PetType petType;
    private LocalDate birthday;

    @Override
    public String toString() {
        return super.toString() + " " +
                "Pet{" +
                "petType=" + petType +
                ", birthday=" + birthday +
                '}';
    }
}
