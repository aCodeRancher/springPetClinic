package com.mcs.springpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "pets")
public class Pet extends NameEntity {

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @Column(name = "birth_date")
    private LocalDate birthday;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    @Override
    public String toString() {
        return super.toString() + " " +
                "Pet{" +
                "petType=" + petType +
                ", birthday=" + birthday +
                '}';
    }
}
