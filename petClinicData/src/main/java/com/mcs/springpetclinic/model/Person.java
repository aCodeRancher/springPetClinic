package com.mcs.springpetclinic.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Person extends BaseEntity {

    private String address;
    private String phone;
    private String city;
    private String firstName;
    private String lastName;
}
