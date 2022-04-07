package com.mcs.springpetclinic.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(callSuper = true)
@NoArgsConstructor
public class Owner extends Person {

    public Owner(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }
}
