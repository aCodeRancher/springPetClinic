package com.mcs.springpetclinic.controller.owner;

import com.mcs.springpetclinic.controllers.owner.OwnerController;
import com.mcs.springpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

abstract class OwnerBaseTest {

    @Mock
    OwnerController ownerController;

    @Mock
    OwnerService ownerService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        ownerController = new OwnerController(ownerService);
    }

}
