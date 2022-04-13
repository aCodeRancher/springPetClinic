package com.mcs.springpetclinic.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;
}
