package com.mcs.springpetclinic.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(callSuper = true)
@NoArgsConstructor
public class Vet extends Person {

    public static class VetBuilder extends Person.PersonBuilder {

        @Override
        public Vet.VetBuilder getThis() {
            return this;
        }

        public Vet.VetBuilder firstName(String first) {
            super.firstName(first);
            return this;
        }

        public Vet.VetBuilder lastName(String last) {
            super.lastName(last);
            return this;
        }

        public Vet.VetBuilder id(Long id) {
            super.id(id);
            return this;
        }

        public Vet build() {
            return new Vet(this);
        }
    }

    public Vet(Vet.VetBuilder builder) {
        super(builder);
    }
}
