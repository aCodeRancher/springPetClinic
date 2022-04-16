package com.mcs.springpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "specialities")
public class Speciality extends NameEntity {

    @Column(name = "description")
    private String description;

    @Override
    public String toString() {
        return "Specialty{" +
                "description='" + description + '\'' +
                '}';
    }
}
