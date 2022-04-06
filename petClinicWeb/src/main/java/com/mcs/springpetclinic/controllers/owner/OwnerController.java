package com.mcs.springpetclinic.controllers.owner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    @GetMapping({"", "/"})
    public String getOwners() {
        return "owners/index";
    }
}
