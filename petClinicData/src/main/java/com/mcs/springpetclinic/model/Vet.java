package com.mcs.springpetclinic.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(callSuper = true)
@NoArgsConstructor
public class Vet extends Person {

    public Vet(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public Vet(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
