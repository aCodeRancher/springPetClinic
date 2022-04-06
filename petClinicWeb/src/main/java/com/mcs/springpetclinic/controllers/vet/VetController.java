package com.mcs.springpetclinic.controllers.vet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vet")
public class VetController {

    @GetMapping({"", "/"})
    public String getAllVets() {
        return "vets/index";
    }
}
