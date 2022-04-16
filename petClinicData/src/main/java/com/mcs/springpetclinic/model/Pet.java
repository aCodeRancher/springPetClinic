package com.mcs.springpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Override
    public String toString() {
        return super.toString() + " " +
                "Pet{" +
                "petType=" + petType +
                ", birthday=" + birthday +
                '}';
    }
}
