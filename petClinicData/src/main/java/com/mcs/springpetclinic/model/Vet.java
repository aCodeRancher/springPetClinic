package com.mcs.springpetclinic.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
public class Vet extends Person {

    private Set<Specialty> specialties;
}
