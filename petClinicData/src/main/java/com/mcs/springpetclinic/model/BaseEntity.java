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

//    @ToString.Exclude
    protected Long id;

    public static abstract class Builder<T extends Builder<T>> {
        private Long id;
        public abstract T getThis();
        public T id(Long val) {
            id = val;
            return getThis();
        }

        public BaseEntity build() {
            return new BaseEntity(this);
        }
    }

    protected BaseEntity(Builder<?> builder) {
        id = builder.id;
    }

}
