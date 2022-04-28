package com.mcs.springpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "types")
public class PetType extends NameEntity {

    @Builder
    public PetType(Long id, String name) {
        super(id, name);
    }
}
