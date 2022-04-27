package com.mcs.springpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class NameEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return this.getName();
    }

}
