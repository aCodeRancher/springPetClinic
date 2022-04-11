package com.mcs.springpetclinic.model;

import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;
}
