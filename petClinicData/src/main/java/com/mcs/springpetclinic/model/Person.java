package com.mcs.springpetclinic.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Person extends BaseEntity {

    protected String firstName;
    protected String lastName;

    public static class PersonBuilder extends BaseEntity.Builder<PersonBuilder> {

        private String firstName;
        private String lastName;

        public PersonBuilder firstName(String first) {
            firstName = first;
            return this;
        }

        public PersonBuilder lastName(String last) {
            lastName = last;
            return this;
        }

        @Override
        public PersonBuilder getThis() {
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    protected Person(PersonBuilder builder) {
        super(builder);
        firstName = builder.firstName;
        lastName = builder.lastName;
    }
}
