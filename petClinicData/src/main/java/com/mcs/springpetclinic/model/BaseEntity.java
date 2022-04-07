package com.mcs.springpetclinic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BaseEntity implements Serializable {

    @ToString.Exclude
    private Long id;

    public BaseEntity(Long id) {
        this.id = id;
    }
}
