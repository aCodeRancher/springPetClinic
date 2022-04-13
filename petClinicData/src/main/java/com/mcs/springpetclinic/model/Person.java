package com.mcs.springpetclinic.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Person extends BaseEntity {

    private String address;
    private String phone;
    private String city;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return super.toString() + " " +
                "Person{" +
                "address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
