package com.mcs.springpetclinic.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(callSuper = true)
@NoArgsConstructor
public class Owner extends Person {

    public static class OwnerBuilder extends Person.PersonBuilder {

        @Override
        public OwnerBuilder getThis() {
            return this;
        }

        public OwnerBuilder firstName(String first) {
            super.firstName(first);
            return this;
        }

        public OwnerBuilder lastName(String last) {
            super.lastName(last);
            return this;
        }

        public OwnerBuilder id(Long id) {
            super.id(id);
            return this;
        }

        public Owner build() {
            return new Owner(this);
        }
    }

    public Owner(OwnerBuilder builder) {
        super(builder);
    }

}
