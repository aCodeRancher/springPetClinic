package com.mcs.springpetclinic.controllers.vet;

import com.mcs.springpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vet")
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping({"", "/"})
    public String getAllVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
