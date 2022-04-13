package com.mcs.springpetclinic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Visit extends BaseEntity {

    private LocalDateTime date;
    private String description;
    private Pet pet;

}
