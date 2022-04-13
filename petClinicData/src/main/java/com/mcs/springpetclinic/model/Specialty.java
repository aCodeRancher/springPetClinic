package com.mcs.springpetclinic.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Specialty extends NameEntity {

    private String description;

    @Override
    public String toString() {
        return super.toString() + " " +
                "Specialty{" +
                "description='" + description + '\'' +
                '}';
    }
}
