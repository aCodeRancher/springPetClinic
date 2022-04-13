package com.mcs.springpetclinic.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
public class Owner extends Person {

    private Set<Pet> pets;
}
