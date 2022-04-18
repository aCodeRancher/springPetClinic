package com.mcs.springpetclinic.exceptions;

public class NoFoundJpaEntityException extends RuntimeException {

    public NoFoundJpaEntityException() {
        super("No such entity found");
    }
}
