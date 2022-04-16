package com.mcs.springpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class NameEntity extends BaseEntity {

    private String name;

    @Override
    public String toString() {
        return super.toString() + " " +
                "NameEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
