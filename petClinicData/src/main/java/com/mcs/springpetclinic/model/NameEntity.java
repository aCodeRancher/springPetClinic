package com.mcs.springpetclinic.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NameEntity extends BaseEntity {

    private String name;

    @Override
    public String toString() {
        return super.toString() + " " +
                "NameEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
