package com.mcs.springpetclinic.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Override
    public String toString() {
        return super.toString() + " " +
                "Owner{" +
                "pets=" + pets +
                '}';
    }
}
