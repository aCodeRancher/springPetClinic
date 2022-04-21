package com.mcs.springpetclinic.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OwnerTest {

    Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        owner.setPhone("123");
    }

    @Test
    public void getOwnerPhone() {
        Assertions.assertEquals("123", owner.getPhone());
    }
}
