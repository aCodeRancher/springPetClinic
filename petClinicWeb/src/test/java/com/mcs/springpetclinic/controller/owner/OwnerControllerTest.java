package com.mcs.springpetclinic.controller.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class OwnerControllerTest extends OwnerBaseTest {

    @Mock
    Model model;

    @Test
    void getOwnerControllerIndexTest() {
        String viewName = ownerController.getIndex(model);

        Assertions.assertEquals("owners/index", viewName);

        verify(ownerService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("owners"), anySet());
    }
}
